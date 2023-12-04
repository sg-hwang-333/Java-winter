package thread.generate;

public class ThreadTest2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++ ) {
			System.out.println("Thread 실행 " + (i+1) +"회");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		ThreadTest2 t1 = new ThreadTest2();
		Thread t2 = new Thread(t1);
		t2.start();

	}

}
