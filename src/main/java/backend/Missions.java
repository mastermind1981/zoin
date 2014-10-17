package backend;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import jpa.Mission;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("missions")
public class Missions {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces("application/json;charset=" + encoding)
	@Path("{missionId}")
	public String getMission(@PathParam("missionId") Long missionId) throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(queryMission(missionId));
	}

	@GET
	@Produces("application/json;charset=" + encoding)
	@Path("lcu/{lcuId}")
	public String getMissionForLcu(@PathParam("lcuId") Long lcuId) throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(queryMissionForLcu(lcuId));
	}

	@GET
	@Produces("application/json;charset=" + encoding)
	public String getMissionsAsJson() throws JsonGenerationException, JsonMappingException, IOException {
		TypedQuery<Mission> q1 = em.createQuery("SELECT x FROM Mission x",
				Mission.class);
		List<Mission> results = q1.getResultList();

		return mapper.writeValueAsString(results);
	}

	private Mission queryMission(Long missionId) {
		TypedQuery<Mission> q1 = em.createQuery("SELECT x FROM Mission x WHERE id='"+missionId+"'",
				Mission.class);
		return q1.getSingleResult();
	}
	private List<Mission> queryMissionForLcu(Long lcuId) {
		TypedQuery<Mission> q1 = em.createQuery("SELECT x FROM Mission x WHERE lcu_id='"+lcuId+"'",
				Mission.class);
		return q1.getResultList();
	}
}
