package scoring;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import jpa.Hero;
import jpa.Mission;
import jpa.Role;
import jpa.Skill;
import jpa.SkillSet;

import objects.Score;

import org.junit.Test;

public class ScoringTest {

	@Test
	public void scoreEqualRole() {
		final Scoring scoring = new Scoring();
		final Hero hero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet(new ArrayList<Skill>()));
		final Mission mission = new Mission(null, null, null, Role.JuniorSoftwareEngineer,
				new SkillSet(new ArrayList<Skill>()));
		assertEquals(new Score(10, true).toString(), scoring.computeScore(hero, mission).toString());
	}
	
	@Test
	public void scoreBySkills() {
		final Scoring scoring = new Scoring();
		final Hero hero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.Java, Skill.SQL)));
		final Mission mission = new Mission(null, null, null, Role.JuniorSoftwareEngineer,
				new SkillSet(Arrays.asList(Skill.Ant, Skill.SQL, Skill.dotNet)));
		assertEquals(new Score(12, true).toString(), scoring.computeScore(hero, mission).toString());
	}

	@Test
	public void scoreDifferentRole() {
		final Scoring scoring = new Scoring();
		final Hero hero = new Hero(null, null, Role.JuniorSoftwareEngineer,
				new SkillSet());
		final Mission mission = new Mission(null, null, null, Role.LeadSoftwareArchitect,
				new SkillSet());
		assertEquals(new Score(0, false).toString(), scoring.computeScore(hero, mission).toString());
	}
}
