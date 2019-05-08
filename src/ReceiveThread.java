import java.io.IOException;

public class ReceiveThread extends Thread {
	private BlockingQueue sq;
	private BlockingQueue rq;
	private Sync sync;
	public ReceiveThread(BlockingQueue sq, BlockingQueue rq, Sync sync) {
		this.sq = sq;
		this.rq = rq;
		this.sync = sync;
	}
	private int[] count(String data) {
		int letters = 0, digits = 0, rest = 0;
		for(int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			if (Character.isLetter(c)) {
				letters++;
			}
			else if (Character.isDigit(c)) {
				digits++;
			}
			else {
				rest++;
			}
		}
		return new int[] {letters, digits, rest};
	}
	public void run() {
		while(true) {
			try {
				if (sync.getFinishedReading() == true && sq.isEmpty()) {
					break;
				}
				String name = (String) sq.pop();
				Result r = new Result(name, count(FileUtils.readFileAsString(name)));
				rq.add(r);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
