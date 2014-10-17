package backend;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jpa.Hero;
import jpa.LCU;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("lcus")
public class Lcus {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces("application/json;charset=" + encoding)
	@Path("{lcuId}")
	public String getLcu(@PathParam("lcuId") Long lcuId) throws JsonGenerationException,
			JsonMappingException, IOException {
		return mapper.writeValueAsString(queryLcu(lcuId));
	}

	private LCU queryLcu(Long lcuId) {
		TypedQuery<LCU> q1 = em.createQuery("SELECT x FROM LCU x WHERE id='"+lcuId+"'",
				LCU.class);
		return q1.getSingleResult();
	}
}
