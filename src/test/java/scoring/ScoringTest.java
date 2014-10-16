package scoring;

import static org.junit.Assert.*;
import jpa.Hero;
import jpa.Mission;
import jpa.Role;
import jpa.SkillSet;

import org.junit.Test;

public class ScoringTest {

	@Test
	public void scoreEqualRole() {
		final Scoring scoring = new Scoring();
		final Hero hero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet());
		final Mission mission = new Mission(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet());
		assertEquals(10, scoring.computeScore(hero, mission));
	}

	@Test
	public void scoreDifferentRole() {
		final Scoring scoring = new Scoring();
		final Hero hero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet());
		final Mission mission = new Mission(null, null, Role.LeadSoftwareArchitect,
				new SkillSet());
		assertEquals(0, scoring.computeScore(hero, mission));
	}
}
