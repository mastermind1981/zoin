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
import objects.SkillMatch;

import org.junit.Before;
import org.junit.Test;

public class ScoringTest {
	private Mission mission;
	private Hero bestMatchingHero;
	private Hero worstMatchingHero;

	private Scoring scoring;

	@Before
	public void setUp() {
		scoring = new Scoring();
		worstMatchingHero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.Java, Skill.SQL)));
		worstMatchingHero.setEducationTarget(Skill.UnitTesting);
		bestMatchingHero = new Hero(null, null, Role.LeadSoftwareArchitect,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.Java, Skill.SQL,
						Skill.Architektur)));
		bestMatchingHero.setEducationTarget(Skill.UITesting);
		mission = new Mission(null, null, null, Role.LeadSoftwareArchitect,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.SQL,
						Skill.Architektur, Skill.UITesting)));
	}

	@Test
	public void computeScoreForHero_bestMatch() {
		final int zoins = 3;
		final Map<Skill, SkillMatch> expectedSkillMatches = new TreeMap<Skill, SkillMatch>();
		expectedSkillMatches.put(Skill.Ant, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.SQL, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.Architektur, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.UITesting, SkillMatch.EducationTarget);
		assertEquals(new Score(10 + 4 + 1 + zoins, true, expectedSkillMatches,
				4).toString(),
				scoring.computeScoreForHero(bestMatchingHero, mission, zoins)
						.toString());
	}

	@Test
	public void computeScoreForHero_worstMatch() {
		final int zoins = 0;
		final Map<Skill, SkillMatch> expectedSkillMatches = new TreeMap<Skill, SkillMatch>();
		expectedSkillMatches.put(Skill.Ant, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.SQL, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.Architektur, SkillMatch.No);
		expectedSkillMatches.put(Skill.UITesting, SkillMatch.No);
		assertEquals(new Score(2 + zoins, false, expectedSkillMatches, 2)
				.toString(),
				scoring.computeScoreForHero(worstMatchingHero, mission, zoins)
						.toString());
	}

	@Test
	public void computeScoreForMission_bestMatch() {
		final int zoins = 2;
		final Map<Skill, SkillMatch> expectedSkillMatches = new TreeMap<Skill, SkillMatch>();
		expectedSkillMatches.put(Skill.Ant, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.Java, SkillMatch.No);
		expectedSkillMatches.put(Skill.SQL, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.Architektur, SkillMatch.Yes);
		assertEquals(
				new Score(13 + zoins, true, expectedSkillMatches, 3).toString(),
				scoring.computeScoreForMission(mission, bestMatchingHero, zoins)
						.toString());
	}

	@Test
	public void computeScoreForMission_worstMatch() {
		final int zoins = 1;
		final Map<Skill, SkillMatch> expectedSkillMatches = new TreeMap<Skill, SkillMatch>();
		expectedSkillMatches.put(Skill.Ant, SkillMatch.Yes);
		expectedSkillMatches.put(Skill.Java, SkillMatch.No);
		expectedSkillMatches.put(Skill.SQL, SkillMatch.Yes);
		assertEquals(
				new Score(2 + zoins, false, expectedSkillMatches, 2).toString(),
				scoring.computeScoreForMission(mission, worstMatchingHero,
						zoins).toString());
	}
}
