package backend;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
	public String getMissions(@QueryParam("hero") int heroId) throws JsonGenerationException,
			JsonMappingException, IOException {
		TypedQuery<Mission> q1 = em.createQuery("SELECT x FROM Mission x",
				Mission.class);
		// FIXME Filter by match for Hero
		List<Mission> results = q1.getResultList();

		return mapper.writeValueAsString(results);
	}

}