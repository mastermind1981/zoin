package scoring;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jpa.Hero;
import jpa.Mission;
import jpa.Skill;
import objects.Score;

public class Scoring {
	private static final int SCORE_FOR_MATCHING_SKILL = 1;
	private static final int SCORE_FOR_MATCHING_ROLE = 10;

	public Score computeScoreForHero(Hero hero, Mission mission) {
		return computeScore(hero.getSkillSet().getSkills(), mission
				.getSkillSet().getSkills(),
				hero.getRole().equals(mission.getRole()));
	}

	public Score computeScoreForMission(Mission mission, Hero hero) {
		return computeScore(mission.getSkillSet().getSkills(), hero
				.getSkillSet().getSkills(),
				hero.getRole().equals(mission.getRole()));
	}

	private Score computeScore(final Set<Skill> requestedSkills,
			final Set<Skill> availableSkills, final boolean roleMatching) {
		int compureScoreBySkills = compureScoreBySkills(requestedSkills,
				availableSkills);
		return new Score((roleMatching ? SCORE_FOR_MATCHING_ROLE : 0)
				+ compureScoreBySkills, roleMatching, computeSkillMatches(
				requestedSkills, availableSkills), compureScoreBySkills);
	}

	private Map<Skill, Boolean> computeSkillMatches(Set<Skill> requestedSkills,
			Set<Skill> availableSkills) {
		final Map<Skill, Boolean> skillMatches = new TreeMap<Skill, Boolean>();
		for (Skill requestedSkill : requestedSkills) {
			skillMatches.put(requestedSkill,
					availableSkills.contains(requestedSkill));
		}
		return skillMatches;
	}

	private int compureScoreBySkills(Set<Skill> requestedSkills,
			Set<Skill> availableSkills) {
		int score = 0;
		for (Skill requestedSkill : requestedSkills) {
			if (availableSkills.contains(requestedSkill)) {
				score += SCORE_FOR_MATCHING_SKILL;
			}
		}
		return score;
	}
}
