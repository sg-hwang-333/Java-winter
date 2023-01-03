package thread.generate;

public class ThreadTest1 extends Thread {
	public ThreadTest1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++ ) {
			System.out.println(getName() + "thread 실행 " + (i+1));
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1("첫번째 "); //new born 상태
		t1.start(); //running
		
		ThreadTest1 t2 = new ThreadTest1("두번째 "); //new born 상태
		t2.start(); //running
	

	}

}
