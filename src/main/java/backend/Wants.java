package backend;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jpa.Hero;
import jpa.Mission;
import jpa.Want;
import objects.WantRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("wants")
public class Wants {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=" + encoding)
	@Path("")
	public void postMission(WantRequest request)
			throws JsonGenerationException, JsonMappingException, IOException {
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"
				+ request.getHeroId() + "'", Hero.class);
		Hero hero = q1.getSingleResult();
		hero.removeZoins(request.getZoins());
		em.persist(hero);
		
		TypedQuery<Mission> q2 = em.createQuery(
				"SELECT x FROM Mission x WHERE id='" + request.getMissionId()
						+ "'", Mission.class);
		Mission mission = q2.getSingleResult();

		Want want = new Want(hero, mission, request.getZoins());
		em.persist(want);
	}

}
