package scoring;

import java.util.Set;

import jpa.Hero;
import jpa.Mission;
import jpa.Skill;

public class Scoring {

	public int computeScore(Hero hero, Mission mission) {
		if (!hero.getRole().equals(mission.getRole())) {
			return 0;
		}
		return 10 + compureScoreBySkills(hero, mission);
	}

	private int compureScoreBySkills(Hero hero, Mission mission) {
		int score = 0;
		final Set<Skill> skillsOfMission = mission.getSkillSet().getSkills();
		for (Skill skillOfHero : hero.getSkillSet().getSkills()) {
			if (skillsOfMission.contains(skillOfHero)) {
				score++;
			}
		}
		return score;
	}

}
