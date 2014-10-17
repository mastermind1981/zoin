package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import jpa.Hero;
import jpa.Mission;
import jpa.Want;
import objects.Match;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import scoring.Scoring;

@PersistenceContext(name = "MySQL")
@Transactional
@Path("matches")
public class Matches {

	private static final String encoding = "UTF-8";

	@PersistenceContext
	EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	private Scoring scoring = new Scoring();

	@GET
	@Produces("application/json;charset=" + encoding)
	public String getMatches(@QueryParam("heroId") Long heroId,
			@QueryParam("missionId") Long missionId)
			throws JsonGenerationException, JsonMappingException, IOException {
		if (heroId != null) {
			final TypedQuery<Mission> q1 = em.createQuery(
					"SELECT x FROM Mission x", Mission.class);
			return mapper.writeValueAsString(createMatchingMissionsForHero(
					heroId, q1.getResultList()));
		} else if (missionId != null) {
			final TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x",
					Hero.class);
			return mapper.writeValueAsString(createMatchingHeroesForMission(
					missionId, q1.getResultList()));
		} else {
			throw new RuntimeException(
					"Parameter 'heroId' or 'missionId' is required!");
		}
	}

	private List<Match> createMatchingHeroesForMission(Long missionId,
			final List<Hero> heroes) {
		final Mission mission = getMission(missionId);
		final List<Match> matches = new ArrayList<Match>();
		for (Hero hero : heroes) {
			matches.add(new Match(
					scoring.computeScoreForMission(mission, hero), mission,
					hero, getZoins(hero, mission)));
		}
		sortMatches(matches);
		return matches;
	}

	private List<Match> createMatchingMissionsForHero(Long heroId,
			final List<Mission> missions) {
		final Hero hero = getHero(heroId);
		final List<Match> matches = new ArrayList<Match>();
		for (Mission mission : missions) {
			matches.add(new Match(scoring.computeScoreForHero(hero, mission),
					mission, hero, getZoins(hero, mission)));
		}
		sortMatches(matches);
		return matches;
	}

	private int getZoins(Hero hero, Mission mission) {
		List<Want> wants = em.createQuery(
				"SELECT x FROM Want x WHERE hero_id='" + hero.getId()
						+ "' AND mission_id='" + mission.getId() + "'",
				Want.class).getResultList();
		if (wants.isEmpty()){
			return 0;
		}
		return wants.get(0).getZoins();
	}

	private void sortMatches(final List<Match> matches) {
		Collections.sort(matches, new Comparator<Match>() {
			@Override
			public int compare(Match match1, Match match2) {
				int compareScore = match2.getScore().getTotalScore()
						- match1.getScore().getTotalScore();
				return compareScore;
			}
		});
	}

	// FIXME remove duplication to Missions.getMission()
	private Mission getMission(Long missionId) {
		TypedQuery<Mission> q1 = em.createQuery(
				"SELECT x FROM Mission x WHERE id='" + missionId + "'",
				Mission.class);
		return q1.getSingleResult();
	}

	// FIXME remove duplication to Heroes.getHero()
	private Hero getHero(Long heroId) {
		TypedQuery<Hero> q1 = em.createQuery("SELECT x FROM Hero x WHERE id='"
				+ heroId + "'", Hero.class);
		return q1.getSingleResult();
	}
}
