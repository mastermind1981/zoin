package scoring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import jpa.Hero;
import jpa.Mission;
import jpa.Role;
import jpa.Skill;
import jpa.SkillSet;
import objects.Score;

import org.junit.Before;
import org.junit.Test;

public class ScoringTest {
	private Mission mission;
	private Hero bestMatchingHero;
	private Hero worstMatchingHero;

	private Scoring scoring;

	@Test
	public void computeScoreForHero_bestMatch() {
		final Map<Skill, Boolean> expectedSkillMatches = new TreeMap<Skill, Boolean>();
		expectedSkillMatches.put(Skill.Ant, true);
		expectedSkillMatches.put(Skill.Java, false);
		expectedSkillMatches.put(Skill.SQL, true);
		expectedSkillMatches.put(Skill.Architektur, true);
		assertEquals(new Score(13, true, expectedSkillMatches).toString(),
				scoring.computeScoreForHero(bestMatchingHero, mission)
						.toString());
	}

	@Test
	public void computeScoreForHero_worstMatch() {
		final Map<Skill, Boolean> expectedSkillMatches = new TreeMap<Skill, Boolean>();
		expectedSkillMatches.put(Skill.Ant, true);
		expectedSkillMatches.put(Skill.Java, false);
		expectedSkillMatches.put(Skill.SQL, true);
		assertEquals(new Score(2, false, expectedSkillMatches).toString(),
				scoring.computeScoreForHero(worstMatchingHero, mission)
						.toString());
	}


	@Test
	public void computeScoreForMission_bestMatch() {
		final Map<Skill, Boolean> expectedSkillMatches = new TreeMap<Skill, Boolean>();
		expectedSkillMatches.put(Skill.Ant, true);
		expectedSkillMatches.put(Skill.SQL, true);
		expectedSkillMatches.put(Skill.Architektur, true);
		expectedSkillMatches.put(Skill.UITesting, false);
		assertEquals(new Score(13, true, expectedSkillMatches).toString(),
				scoring.computeScoreForMission(mission, bestMatchingHero)
						.toString());
	}

	@Test
	public void computeScoreForMission_worstMatch() {
		final Map<Skill, Boolean> expectedSkillMatches = new TreeMap<Skill, Boolean>();
		expectedSkillMatches.put(Skill.Ant, true);
		expectedSkillMatches.put(Skill.SQL, true);
		expectedSkillMatches.put(Skill.Architektur, false);
		expectedSkillMatches.put(Skill.UITesting, false);
		assertEquals(new Score(2, false, expectedSkillMatches).toString(),
				scoring.computeScoreForMission(mission, worstMatchingHero)
						.toString());
	}
	
	@Before
	public void setUp() {
		scoring = new Scoring();
		worstMatchingHero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.Java, Skill.SQL)));
		bestMatchingHero = new Hero(null, null, Role.LeadSoftwareArchitect,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.Java, Skill.SQL,
						Skill.Architektur)));
		mission = new Mission(null, null, null, Role.LeadSoftwareArchitect,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.SQL,
						Skill.Architektur, Skill.UITesting)));
	}
}
