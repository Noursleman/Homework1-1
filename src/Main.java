import java.io.IOException;

public class Main {

	private static int[] count(String data) {
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

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			String name = String.format("data/f%d.txt", i);
			String text = FileUtils.readFileAsString(name);
			int[] result = count(text);
			String line = String.format("%s: %d, %d, %d", name, result[0], result[1], result[2]);
			FileUtils.appendStringToFile("data/result1.txt", line);
		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);*/
		startTime = System.currentTimeMillis();
		BlockingQueue sq = new BlockingQueue(1000);
		BlockingQueue rq = new BlockingQueue(1000);
		Sync sync = new Sync();
		GenerateThread gt = new GenerateThread(sq, sync);
		WriteThread wt = new WriteThread(rq);
		gt.start();
		wt.start();
		ReceiveThread[] rts = new ReceiveThread[10];
		for (int i = 0; i < rts.length; i++) {
			rts[i] = new ReceiveThread(sq, rq, sync);
			rts[i].start();
		}
		for(ReceiveThread rt : rts) {
			rt.join();
		}
		gt.join();
		wt.join();
		stopTime = System.currentTimeMillis();
	    elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
	}

}
