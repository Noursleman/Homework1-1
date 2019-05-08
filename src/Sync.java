
public class Sync {
	private Boolean finishedReading;
	public Sync() {
		finishedReading = false;
	}
	public synchronized void setFinishedReading(Boolean val) {
		finishedReading = val;
	}
	public synchronized Boolean getFinishedReading() {
		return finishedReading;
	}
}
