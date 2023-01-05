package stoneAvoidance.game;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DiamondFall extends Thread {
	JLabel diamond;
	JLabel chara;
	JLabel scorelbl;
	int x = getXLocation(), y = -20;
	int speed = YSpeed();
	int score;
	
	public DiamondFall(JLabel diamond, JLabel chara, JLabel scorelbl, int score) {
		this.diamond = diamond;
		this.chara = chara;
		this.scorelbl = scorelbl;
		this.score = score;
	}
	
	public int getXLocation() {
		x = (int) (Math.random() * 560);
		return x;
	}
	
	public int YSpeed() {
		speed = (int) (Math.random() * 5 + 1);
		return speed;
	}
	
	@Override
	public void run() {
		while(true) {
			diamond.setLocation(x, y);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y += speed;
			
			if ((diamond.getX() >= chara.getX() && diamond.getX()+50 <= chara.getX())
					|| (diamond.getY() >= chara.getY() && diamond.getY() <= chara.getY()) )
				{
					score += 20;
					scorelbl.setText("점수 : " + Integer.toString(score));
				}
			
			if (y >= 400) break;
		}
	}
}
