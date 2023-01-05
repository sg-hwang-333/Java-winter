package stoneAvoidance.game;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StoneFall extends Thread {
	JLabel stone;
	JLabel chara;
	int x = getXLocation(), y = -20;
	int speed = YSpeed();
	JLabel scorelbl;
	int score;
	static int FINISH = 1;
	
	public StoneFall(JLabel stone, JLabel chara, JLabel scorelbl, int score) {
		this.stone = stone;
		this.chara = chara;
		this.scorelbl = scorelbl;
		this.score = score;
		FINISH = 1;
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
			stone.setLocation(x, y);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y += speed;
			
			if ((stone.getX() >= chara.getX() && stone.getX()+50 <= chara.getX())
					|| (stone.getY() >= chara.getY() && stone.getY() <= chara.getY()) )
				{
					score -= 10;
					scorelbl.setText("점수 : " + Integer.toString(score));
				}
			
			if (y >= 400) break;
		}
		
		if (FINISH == 20) {
			FINISH++;
			JOptionPane.showMessageDialog(null, "최종점수 : " + score);
		}
	}

}
