package objects;

public class Match {
	
	private int value;
	private Long missionID;
	private Long heroId;
	
	public Match(){
	}
	
	public Match(int value, Long missionID, Long heroId) {
		this.value = value;
		this.missionID = missionID;
		this.heroId = heroId;
	}

	public int getValue() {
		return value;
	}
	public Long getMissionID() {
		return missionID;
	}
	public Long getHeroId() {
		return heroId;
	}
}
