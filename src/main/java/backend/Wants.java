package backend;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import jpa.Mission;
import jpa.Want;

import objects.WantRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("want")
public class Wants {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Produces("application/json;charset=" + encoding)
	@Path("{heroId}")
	public String getMissions(@PathParam("heroId") String heroId) throws JsonGenerationException, JsonMappingException, IOException {
		TypedQuery<Want> q1 = em.createQuery("SELECT x FROM Want x WHERE hero_id='"  + heroId + "'",
				Want.class);
		List<Want> results = q1.getResultList();
		
		Set<Long> missionIds = new HashSet<Long>();
		for (Want want : results) {
			missionIds.add(want.getMission().getId());
		}

		return mapper.writeValueAsString(missionIds);
	}
	
	@POST
	@Produces("application/json;charset=" + encoding)
	@Path("{heroId}/{missionId}")
	public void postMission(@PathParam("heroId") String heroId, @PathParam("missionId") String missionId) throws JsonGenerationException, JsonMappingException, IOException {
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"+heroId+"'",
				Hero.class);
		Hero hero = q1.getSingleResult();
		
		TypedQuery<Mission> q2 = em.createQuery("SELECT x FROM Mission x WHERE id='"+missionId+"'",
				Mission.class);
		Mission mission = q2.getSingleResult();
		
		Want want = new Want(hero, mission);
		em.persist(want);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=" + encoding)
	@Path("")
	public void postMission(WantRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"+request.getHeroId()+"'",
				Hero.class);
		Hero hero = q1.getSingleResult();
		
		TypedQuery<Mission> q2 = em.createQuery("SELECT x FROM Mission x WHERE id='"+request.getMissionId()+"'",
				Mission.class);
		Mission mission = q2.getSingleResult();
		
		Want want = new Want(hero, mission);
		em.persist(want);
	}

}
