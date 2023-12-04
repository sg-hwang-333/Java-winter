package stoneAvoidance.game;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class StoneAvoidanceGame extends JFrame{
	JPanel pan;
	JLabel chara;
	StoneFall sf; 
	DiamondFall df; 
	static int stoneNum;
	JLabel stone[];
	JLabel diamond[] = new JLabel[10];
	JButton startBtn;
	JLabel scorelbl;
	int score = 0;
	int FINISH = 0;
	String[] chIconWay = {"Image/보름달.png", "Image/신월.png"};
	ImageIcon charaicon;
	
	
	public StoneAvoidanceGame(int count) {
		
		if (count != 0) {
			stoneNum += 20;
		} else {
			stoneNum = 20;
		}
		stone = new JLabel[stoneNum];
		pan = new JPanel();
		pan.setLayout(null);
		charaicon = new ImageIcon(chIconWay[0]);
		chara = new JLabel(charaicon);
		chara.setLocation(270, 320);
		chara.setSize(40,40);
		chara.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	String icon = (String)JOptionPane.showInputDialog(null,"캐릭터를 선택해주세요.","캐릭터 선택 화면",JOptionPane.WARNING_MESSAGE,null,chIconWay,chIconWay[0]);
            	charaicon = new ImageIcon(icon);
            	chara.setIcon(charaicon);
            }
        });
		
		startBtn = new JButton("시작하기");
		startBtn.setLocation(230, 40);
		startBtn.setSize(100,40);
		startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	startBtn.setVisible(false);
            	for (int i = 0; i < stone.length; i++ ) {
        			stone[i] = new JLabel(new ImageIcon("Image/돌.png"));
        			stone[i].setSize(50,50);
        			sf = new StoneFall(stone[i], chara, scorelbl);
        			pan.add(stone[i]);
        			sf.start();
        			
        		}
            	for (int i = 0; i< diamond.length; i++ ) {
            		diamond[i] = new JLabel(new ImageIcon("Image/다이아.png"));
            		diamond[i].setSize(50,50);
        			df = new DiamondFall(diamond[i], chara, scorelbl);
        			pan.add(diamond[i]);
        			df.start();
            	}
           }
        });
		
		
        
		scorelbl = new JLabel();
		scorelbl.setText("0점");
		scorelbl.setLocation(0, 0);
		scorelbl.setSize(500,10);
		
        addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) { 
        		switch (e.getKeyCode()) {
        		case KeyEvent.VK_DOWN: case KeyEvent.VK_S: 
        			if (chara.getY() < 320)
        				chara.setLocation(chara.getX(), chara.getY()+8);
					break;
				case KeyEvent.VK_UP: case KeyEvent.VK_W:
					if (chara.getY() > 0)
						chara.setLocation(chara.getX(), chara.getY()-8);
					break;
        		case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
        			if (chara.getX() > 0)
        				chara .setLocation(chara .getX()-8, chara .getY());
        			break;
        		case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
        			if (chara.getX() < 545)
        				chara .setLocation(chara .getX()+8, chara .getY());
        			break;
        		default:
        			break;
        		}
        	}
        });
        
        
		pan.setBackground(Color.WHITE);
		pan.add(scorelbl);
		pan.add(startBtn);
		pan.add(chara);
		add(pan);
		setTitle("돌 피하기 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,200,600,400);
		setResizable(false);
		setVisible(true);
		setFocusable(true);
		requestFocus(); 
		
	}
	class StoneFall extends Thread {
		JLabel stone;
		JLabel chara;
		int x = getXLocation(), y = -20;
		int speed = YSpeed();
		JLabel scorelbl;
		
		public StoneFall(JLabel stone, JLabel chara, JLabel scorelbl) {
			this.stone = stone;
			this.chara = chara;
			this.scorelbl = scorelbl;
		}
		
		public int getXLocation() {
			x = (int) (Math.random() * 560);
			return x;
		}
		
		public int YSpeed() {
			speed = (int) (Math.random() * 7 + 1);
			return speed;
		}
		
		@Override
		public void run() {
			while(true) {
				stone.setLocation(x, y);
				try {
					sleep(70);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				y += speed;
				
				
				if((chara.getX()<stone.getX()+50 && chara.getX()>stone.getX())
					&& (chara.getY()<stone.getY()+50&&chara.getY()>stone.getY() )) {
						score -= 10;
						scorelbl.setText("점수 : " + Integer.toString(score));
						
				}
				
				if (y >= 368) break;
				
			}
			FINISH++;
			if (FINISH >= stoneNum+diamond.length) {
				JOptionPane.showMessageDialog(null, "최종점수 : " + score);
			}
			if (FINISH >= stoneNum+diamond.length && score >= 2000) {
				int select = JOptionPane.showConfirmDialog(null, "다음 난이도로 가겠습니까?", "확인 창", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null);
				if (select == 0) {
					new StoneAvoidanceGame(1);
					dispose();
					return;
				} else {
					System.exit(0);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		new StoneAvoidanceGame(0);

	}
	class DiamondFall extends Thread {
		JLabel diamond;
		JLabel chara;
		JLabel scorelbl;
		int x = getXLocation(), y = -20;
		int speed = YSpeed();
		
		public DiamondFall(JLabel diamond, JLabel chara, JLabel scorelbl) {
			this.diamond = diamond;
			this.chara = chara;
			this.scorelbl = scorelbl;
		}
		
		public int getXLocation() {
			x = (int) (Math.random() * 560);
			return x;
		}
		
		public int YSpeed() {
			speed = (int) (Math.random() * 7 + 1);
			return speed;
		}
		
		@Override
		public void run() {
			while(true) {
				diamond.setLocation(x, y);
				try {
					sleep(65);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				y += speed;
				
				if ((chara.getX()<diamond.getX()+50 && chara.getX()>diamond.getX())
						&& (chara.getY()<diamond.getY()+50&&chara.getY()>diamond.getY() ))
					{
						score += 20;
						scorelbl.setText("점수 : " + Integer.toString(score));
						
					}
				
				if (y >= 368) break;
			}
			FINISH++;
			if (FINISH >= stoneNum+10 && score >= 2000) {
				score = 0;
				return;
			}
		}
	}

}
