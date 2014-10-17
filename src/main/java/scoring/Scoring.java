package scoring;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jpa.Hero;
import jpa.Mission;
import jpa.Skill;
import objects.Score;
import objects.SkillMatch;

public class Scoring {
	private static final int SCORE_FOR_MATCHING_SKILL = 1;
	private static final int ADDITIONAL_SCORE_FOR_MATCHING_EDUCATION_TARGET = 1;
	private static final int SCORE_FOR_MATCHING_ROLE = 10;

	public Score computeScoreForHero(Hero hero, Mission mission, Integer zoins) {
		return computeScore(mission.getSkillSet().getSkills(), hero
				.getSkillSet().getSkills(), hero.getEducationTarget(), hero
				.getRole().equals(mission.getRole()), zoins);
	}

	public Score computeScoreForMission(Mission mission, Hero hero,
			Integer zoins) {
		return computeScore(hero.getSkillSet().getSkills(), mission
				.getSkillSet().getSkills(), hero.getEducationTarget(), hero
				.getRole().equals(mission.getRole()), zoins);
	}

	private Score computeScore(final Set<Skill> requestedSkills,
			final Set<Skill> availableSkills, Skill educationTarget,
			final boolean roleMatching, Integer zoins) {
		int scoreBySkills = compureScoreBySkills(requestedSkills,
				availableSkills, educationTarget);
		return new Score(computeTotalScore(roleMatching, scoreBySkills,
				requestedSkills, educationTarget, zoins), roleMatching,
				computeSkillMatches(requestedSkills, availableSkills,
						educationTarget), scoreBySkills);
	}

	private int computeTotalScore(final boolean roleMatching,
			int compureScoreBySkills, Set<Skill> requestedSkills,
			Skill educationTarget, Integer zoins) {
		return (roleMatching ? SCORE_FOR_MATCHING_ROLE : 0)
				+ compureScoreBySkills
				+ (zoins == null ? 0 : zoins.intValue()
						+ computeScoreForEductionTarget(educationTarget,
								requestedSkills));
	}

	private int computeScoreForEductionTarget(Skill educationTarget,
			Set<Skill> requestedSkills) {
		if (educationTarget != null
				&& requestedSkills.contains(educationTarget)) {
			return ADDITIONAL_SCORE_FOR_MATCHING_EDUCATION_TARGET;
		} else {
			return 0;
		}
	}

	private Map<Skill, SkillMatch> computeSkillMatches(
			Set<Skill> requestedSkills, Set<Skill> availableSkills,
			Skill educationTarget) {
		final Map<Skill, SkillMatch> skillMatches = new TreeMap<Skill, SkillMatch>();
		for (Skill requestedSkill : requestedSkills) {
			SkillMatch skillMatch;
			if (requestedSkill.equals(educationTarget)) {
				skillMatch = SkillMatch.EducationTarget;
			} else {
				if (availableSkills.contains(requestedSkill)) {
					skillMatch = SkillMatch.Yes;
				} else {
					skillMatch = SkillMatch.No;
				}
			}
			skillMatches.put(requestedSkill, skillMatch);
		}
		return skillMatches;
	}

	private int compureScoreBySkills(Set<Skill> requestedSkills,
			Set<Skill> availableSkills, Skill educationTarget) {
		int score = 0;
		for (Skill requestedSkill : requestedSkills) {
			if (availableSkills.contains(requestedSkill)) {
				score += SCORE_FOR_MATCHING_SKILL;
			}
		}
		if (requestedSkills.contains(educationTarget)) {
			score += SCORE_FOR_MATCHING_SKILL;
		}
		return score;
	}
}
