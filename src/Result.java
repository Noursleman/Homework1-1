
public class Result {
	private String name;
	private int[] count;
	
	public Result(String name, int[] count) {
		this.name = name;
		this.count = count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setCount(int[] c) {
		count = c;
	}
	public int[] getCount() {
		return count;
	}

}
