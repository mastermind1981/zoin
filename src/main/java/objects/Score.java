package objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Score {
	private int totalScore;
	private boolean roleMatching;

	public Score(){
	}
	
	public Score(int totalScore, boolean roleMatching) {
		this.totalScore = totalScore;
		this.roleMatching = roleMatching;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public boolean isRoleMatching() {
		return roleMatching;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
