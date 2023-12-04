package gui.test;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 독립된 ActionListener 클래스를 사용
@SuppressWarnings("serial")
public class JFrameTest5 extends JFrame {
	ImageIcon icon = new ImageIcon("dokjil/1.png");
	JLabel lbl = new JLabel(icon, JLabel.CENTER);
	
	
	JButton btn1 = new JButton("레익");
	JButton btn2 = new JButton("레식");
	JButton btn3 = new JButton("고스트리콘");
	
	
	public JFrameTest5() {
		
		ButtonListener btnls = new ButtonListener(btn1, btn2, lbl);
		btn1.addActionListener(btnls);
		btn2.addActionListener(btnls);
		btn3.addActionListener(btnls);
		
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
		new JFrameTest5();

	}
	

}
