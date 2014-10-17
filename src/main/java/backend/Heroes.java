package backend;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jpa.Hero;
import objects.EducationRequest;
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
	public String getHeroAsJson(@PathParam("heroId") Long heroId) throws JsonGenerationException,
			JsonMappingException, IOException {
		return mapper.writeValueAsString(getHero(heroId));
	}

	private Hero getHero(Long heroId) {
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"+heroId+"'",
				Hero.class);
		return q1.getSingleResult();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=" + encoding)
	@Path("")
	public void postMission(EducationRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"+request.getHeroId()+"'",
				Hero.class);
		Hero hero = q1.getSingleResult();
		
		hero.setEducationTarget(request.getSkill());
		em.persist(hero);
	}
}
