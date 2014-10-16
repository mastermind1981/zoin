package objects;

public class Match {
	private Long missionID;
	private Long heroId;
	private Score score;

	public Match(){}
	
	public Match(Score score, Long missionId, Long heroId) {
		this.score = score;
		this.missionID = missionId;
		this.heroId = heroId;
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
}
