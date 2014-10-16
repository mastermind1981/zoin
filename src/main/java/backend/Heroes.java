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

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("heroes")
public class Heroes {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces("application/json;charset=" + encoding)
	@Path("{heroId}")
	public String getHero(@PathParam("heroId") String heroId) throws JsonGenerationException,
			JsonMappingException, IOException {

		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"+heroId+"'",
				Hero.class);
		Hero results = q1.getSingleResult();

		return mapper.writeValueAsString(results);
	}

}
