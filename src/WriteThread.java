import java.io.IOException;

public class WriteThread extends Thread {
	private BlockingQueue rq;
	public WriteThread(BlockingQueue rq) {
		this.rq = rq;
	}
	
	public void run() {
		int c = 0;
		while(true) {
			try {
				Result result = (Result) rq.pop();
				int[] count = result.getCount();
				String line = String.format("%s: %d, %d, %d", result.getName(), count[0], count[1], count[2]);
				//System.out.println(line);
				FileUtils.appendStringToFile("data/result.txt", line);
				c++;
				if (c == 100) {
					break;
				}
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
