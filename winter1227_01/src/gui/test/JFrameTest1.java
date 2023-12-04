package gui.test;
import javax.swing.*;
public class JFrameTest1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("dokjil/1.png");
		label.setIcon(icon); 
		frame.add(label);
		
		frame.setTitle("JFrame Test 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200,300);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

}
