package generation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jpa.Role;
import jpa.Skill;


public class Main {

	private static final int MAX_MISSION_SKILLS = 5;
	private static final int MAX_HERO_SKILLS = 5;
	private static final String NEWLINE = "\n";
	private static final int NUMBER_OF_HEROES = 1000;
	private static final int NUMBER_OF_MISSIONS = 1000;
	private static final int HERO_OFFSET = 1000;
	private static final int MISSION_OFFSET = 11000;
	
	private static final NameGenerator nameGenerator = new NameGenerator();

	public static void main(String[] args) throws IOException {
		StringBuffer buffer = new StringBuffer();
		for (int i = HERO_OFFSET; i < NUMBER_OF_HEROES + HERO_OFFSET; i++) {
			appendHero(buffer, i);
		}
		for (int i = MISSION_OFFSET; i < NUMBER_OF_MISSIONS + MISSION_OFFSET; i++) {
			appendMission(buffer, i);
		}
		
		BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("import.sql")));
        
		bwr.write(buffer.toString());
        bwr.flush();
        bwr.close();
	}

	private static void appendHero(StringBuffer buffer, int heroId) {
		appendSkillSet(buffer, heroId);

		int numberOfSkills = (int) (Math.floor(Math.random() * MAX_HERO_SKILLS) + 1);
		for (int i = 0; i < numberOfSkills; i++) {
			Skill skill = getRandomSkill();
			appendSkills(buffer, heroId, skill);
		}
		
		String firstname = nameGenerator.getName();
		String lastname = nameGenerator.getName();
		Role role = getRandomRole();
		buffer.append("INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES " +
				"('" + heroId + "', '" + firstname + "', '" + lastname + "', '" + role + "', '" + heroId + "');" + NEWLINE);
	}

	private static void appendMission(StringBuffer buffer, int missionId) {
		appendSkillSet(buffer, missionId);

		int numberOfSkills = (int) (Math.floor(Math.random() * MAX_MISSION_SKILLS) + 1);
		for (int i = 0; i < numberOfSkills; i++) {
			Skill skill = getRandomSkill();
			appendSkills(buffer, missionId, skill);
		}
		
		String companyName = nameGenerator.getName();
		String shortName = nameGenerator.getName();
		Role role = getRandomRole();
		buffer.append("INSERT INTO `Mission` (`id`, `companyName`, `shortName`, `role`, `skillSet_id`) VALUES " +
				"('" + missionId + "', '" + companyName + "', '" + shortName + "', '" + role + "', '" + missionId + "');" + NEWLINE);
	}

	private static void appendSkills(StringBuffer buffer, int heroId,
			Skill skill) {
		buffer.append("INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES " +
				"('" + heroId + "', '" + skill + "');" + NEWLINE);
	}

	private static void appendSkillSet(StringBuffer buffer, int heroId) {
		buffer.append("INSERT INTO `SkillSet` (`id`) VALUES " +
				"('" + heroId + "');" + NEWLINE);
	}

	private static Skill getRandomSkill() {
		int i = (int) (Math.random() * 1000);
		Skill[] values = Skill.values();
		return values[i % values.length];
	}

	private static Role getRandomRole() {
		int i = (int) (Math.random() * 1000);
		Role[] values = Role.values();
		return values[i % values.length];
	}
}
