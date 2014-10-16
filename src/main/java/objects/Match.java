package objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Match {
	private Long missionID;
	private Long heroId;
	private Score score;
	private boolean wanted;

	public Match() {
	}

	public Match(Score score, Long missionId, Long heroId, boolean wanted) {
		this.score = score;
		this.missionID = missionId;
		this.heroId = heroId;
		this.wanted = wanted;
	}

	public Score getScore() {
		return score;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Long getHeroId() {
		return heroId;
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
