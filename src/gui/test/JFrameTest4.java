package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Anonymous(익명) 클래스로 ActionListener를 구현
@SuppressWarnings("serial")
public class JFrameTest4 extends JFrame {
	ImageIcon icon = new ImageIcon("dokjil/1.png");
	JLabel lbl = new JLabel(icon, JLabel.CENTER);
	
	JButton btn1 = new JButton("레익");
	JButton btn2 = new JButton("레식");
	JButton btn3 = new JButton("고스트리콘");
	
	
	public JFrameTest4() {
		
		
		btn1.addActionListener(btnListener);
		btn2.addActionListener(btnListener);
		btn3.addActionListener(btnListener);
		
		JPanel pan = new JPanel();
		
		
		setTitle("JFrame 상속 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,200);
		setSize(500,500);
		setVisible(true);
		
		pan.add(btn1);
		pan.add(btn2);
		pan.add(btn3);
		add(pan, "North");
		add(lbl, "Center");
	}

	public static void main(String[] args) {
		new JFrameTest4();

	}
	
	ActionListener btnListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				Object btnSource = e.getSource();
				if(btnSource == btn1) {
					icon = new ImageIcon("dokjil/20220125_230129.jpg");
				} else if (btnSource == btn2) {
					icon = new ImageIcon("dokjil/1.png");
				} else {
					icon = new ImageIcon("dokjil/20211111_150434.jpg");
				}
				
				lbl.setIcon(icon);
			
		}
	};
}
