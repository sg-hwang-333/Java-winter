package thread.running;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageRunning extends JFrame {
	JPanel pan;
	String name;
	JButton startBtn;
	JLabel lbl[] = new JLabel[3];
	JLabel namelbl[] = new JLabel[3];
	JLabel endline;
	
	public ImageRunning() {
		
		pan = new JPanel();
		pan.setLayout(null);
		endline = new JLabel(new ImageIcon("Image/결승선.png"));
		endline.setSize(3,250);
		endline.setLocation(360, 0);
		pan.add(endline);
		
		
		startBtn = new JButton("출발!");
		for (int i = 0; i < 3; i++ ) {
			namelbl[i] = new JLabel();
			namelbl[i].setLocation(0, i * 100 + 45);
			namelbl[i].setSize(30,20);
			pan.add(namelbl[i]);
		}
		for (int i = 0; i < 3; i++) {
			lbl[i] = new JLabel();
			ImageIcon icon = new ImageIcon("Image/" + i + ".png");
			lbl[i].setIcon(icon);
			lbl[i].setLocation(0, i * 100);
			lbl[i].setSize(40,40);
			pan.add(lbl[i]);
		}
		startBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 3; i++ ) {
					RunningThread r;
					r = new RunningThread(lbl[i], i, namelbl[i]);
					r.start();
				}
			}
		});
		lbl[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	name = JOptionPane.showInputDialog("말의 이름을 적어주세요!");
            	namelbl[0].setText(name);
            }
        });
		lbl[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	name = JOptionPane.showInputDialog("말의 이름을 적어주세요!");
            	namelbl[1].setText(name);
            }
        });
		lbl[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	name = JOptionPane.showInputDialog("말의 이름을 적어주세요!");
            	namelbl[2].setText(name);
            }
        });
		startBtn.setSize(70,30);
		startBtn.setLocation(165, 300);
		pan.add(startBtn);
		add(pan);
		pan.setBackground(Color.WHITE);
		setTitle("Image Running");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600,200,400,400);
		setVisible(true);
		setResizable(false);
	}
	

	public static void main(String[] args) {
		new ImageRunning();

	}

}
