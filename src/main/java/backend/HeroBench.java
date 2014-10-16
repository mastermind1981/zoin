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

import jpa.Hero;
import jpa.Role;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("heroBench")
public class HeroBench {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces("application/json;charset=" + encoding)
	public String getClichedMessage() throws JsonGenerationException,
			JsonMappingException, IOException {

		// FIXME do not create another entity
		Hero entity = new Hero("Hans","Muster",Role.LeadSoftwareArchitect, null);
		em.persist(entity);
		
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x",
				Hero.class);
		List<Hero> results = q1.getResultList();

		return mapper.writeValueAsString(results);
	}

}
