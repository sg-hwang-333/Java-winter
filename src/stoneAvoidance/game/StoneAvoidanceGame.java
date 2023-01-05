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
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StoneAvoidanceGame extends JFrame{
	JPanel pan;
	JLabel chara;
	StoneFall sf; 
	DiamondFall df;
	JLabel stone[] = new JLabel[20];
	JLabel diamond[] = new JLabel[10];
	JButton startBtn;
	JLabel scorelbl;
	int score = 0;
	
	
	public StoneAvoidanceGame() {
		pan = new JPanel();
		pan.setLayout(null);
		
		chara = new JLabel(new ImageIcon("Image/달.png"));
		chara.setLocation(270, 320);
		chara.setSize(40,40);
		
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
        			sf = new StoneFall(stone[i], chara, scorelbl, score);
        			pan.add(stone[i]);
        			sf.start();
        			
        		}
            	for (int i = 0; i< diamond.length; i++ ) {
            		diamond[i] = new JLabel(new ImageIcon("Image/다이아.png"));
            		diamond[i].setSize(50,50);
        			df = new DiamondFall(diamond[i], chara, scorelbl, score);
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
        		case KeyEvent.VK_DOWN: //방향키(아래) 눌렀을때
        			if (chara.getY() < 320)
        				chara.setLocation(chara.getX(), chara.getY()+8);
					break;
				case KeyEvent.VK_UP: //방향키(위)눌렀을때
					if (chara.getY() > 0)
						chara.setLocation(chara.getX(), chara.getY()-8);
					break;
        		case KeyEvent.VK_LEFT:// 방향키(왼)눌렀을때
        			if (chara.getX() > 0)
        				chara .setLocation(chara .getX()-8, chara .getY());
        			break;
        		case KeyEvent.VK_RIGHT:// 방향키(오른)눌렀을때
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

	public static void main(String[] args) {
		new StoneAvoidanceGame();

	}
	

}
