package thread.slideshow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ImageSlideShow extends JFrame {
	JPanel infoPanel;
	JPanel bottomPanel;
	JLabel lbl;
	JTextField tf;
	JButton setBtn;
	int second;
	ImageThread t;
	
	public ImageSlideShow() {
		infoPanel = new JPanel();
		ImageIcon icon = new ImageIcon("Images/1.jpg");
		lbl = new JLabel(icon);
		bottomPanel = new JPanel();
		tf = new JTextField(15);
		
		setBtn = new JButton("설정");
		setBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				second = (int) (Double.parseDouble(tf.getText()) * 1000.0);
				t.setTime(second);
			}
		});
		
		infoPanel.add(tf);
		infoPanel.add(setBtn);
		bottomPanel.add(lbl,"Center");
		
		add(infoPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		
		setTitle("이미지 슬라이드 쇼");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(20,30,400,400);
		setVisible(true);
		setResizable(false);
		t = new ImageThread(lbl);
		t.start();
		
	}
	public static void main(String[] args) {
		new ImageSlideShow();
	}

}
