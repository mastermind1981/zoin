package scoring;

import jpa.Hero;
import jpa.Mission;

public class Scoring {

	public int computeScore(Hero hero, Mission mission) {
		int score = 0;
		if (hero.getRole().equals(mission.getRole())) {
			score += 10;
		}
		return score;
	}

}
