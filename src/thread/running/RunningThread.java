package thread.running;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RunningThread extends Thread {
	JLabel lbl;
	int x = 0;
	int i;
	static int winNum = 1;
	JLabel namelbl;
	
	public RunningThread(JLabel lbl, int i, JLabel namelbl) {
		super();
		this.lbl = lbl;
		this.i = i;
		this.namelbl = namelbl;
	}
	
	public int setSpeed() {
		x += (int) (Math.random() * 15);
		return x;
	}
	
	@Override
	public void run() {
		while(true) {
			int speed = setSpeed();
			lbl.setLocation(speed, i * 100);
			namelbl.setLocation(speed, i * 100 + 45);
			try {
				sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (x >= 324 && winNum == 1) {
				winNum++;
				JOptionPane.showMessageDialog(null, (i+1) + "번째 달이 이겼습니다!");
				break;
				
			} else if(x >= 324) {
				break;
			}
			/*else if(winNum > 1) {
				break;
			}*/
		}
		
	}
}
