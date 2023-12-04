package thread.slideshow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageThread extends Thread{
	
	JLabel lbl;
	int time = 1000;
	public ImageThread(JLabel lbl) {
		this.lbl = lbl;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		int i = 0;
		ImageIcon icon;
		while (true) {
			icon = new ImageIcon("Images/" + i + ".jpg");
			lbl.setIcon(icon);
			
			if (++i == 5) {
				i = 0;
			}
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
