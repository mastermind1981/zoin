package objects;

import jpa.Hero;
import jpa.Mission;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Match {
	private Mission mission;
	private Hero hero;
	private Score score;
	private boolean wanted;

	public Match() {
	}

	public Match(Score score, Mission mission, Hero hero, boolean wanted) {
		this.score = score;
		this.mission = mission;
		this.hero = hero;
		this.wanted = wanted;
	}

	public Score getScore() {
		return score;
	}

	public Mission getMission() {
		return mission;
	}

	public Hero getHero() {
		return hero;
	}
	
	public boolean isWanted() {
		return wanted;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
