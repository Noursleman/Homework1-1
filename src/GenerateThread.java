
public class GenerateThread extends Thread {
	private BlockingQueue sq;
	private Sync sync;
	public GenerateThread(BlockingQueue sq, Sync sync) {
		this.sq = sq;
		this.sync = sync;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			String name = String.format("data/f%d.txt", i);
			try {
				sq.add(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sync.setFinishedReading(true);
	}

}
