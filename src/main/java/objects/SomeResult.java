package objects;

public class SomeResult {
	
	private int count;
	private String comment = "# of objects in DB";
	
	public SomeResult() {
	}
	
	public SomeResult(int c) {
		count = c;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
