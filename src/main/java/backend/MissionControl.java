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

import jpa.Mission;
import jpa.Role;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("missionControl")
public class MissionControl {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces("text/plain;charset=" + encoding)
	public String getClichedMessage() throws JsonGenerationException,
			JsonMappingException, IOException {

		// FIXME: Do not create a new entity every time
		Mission entity = new Mission("Mission 1", "Swisscom",
				Role.SeniorSoftwareEngineer, null);

		em.persist(entity);

		TypedQuery<Mission> q1 = em.createQuery("SELECT x FROM Mission x",
				Mission.class);
		List<Mission> results = q1.getResultList();

		return mapper.writeValueAsString(results);
	}

}
