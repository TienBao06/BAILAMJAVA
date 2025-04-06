package MultiThread1;

public class Producer extends Thread {
	Store store = null;
	long index = 1;
	public Producer (Store s) {
		store = s;
	}
	public void run() {
		while (true) {
			try {
				boolean result = store.put(index);
				if ( result == true) System.out.println("** Product "+(index++)+" is made.");
				else System.out.println("Store if full!");
			} catch ( Exception e) {
				
			}
		}
	}
}