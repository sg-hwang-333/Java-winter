package bmi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import bmi.vo.BMIVO;

@SuppressWarnings("serial")
public class BMIView extends JPanel{
	JPanel infoPanel;
		JLabel infoLabel;
		String title = "--------------------------     체질량지수(BMI)     --------------------------";
		
	JPanel setPanel;
		String[] name = {"키 : ", "체중 : "};
		JLabel[] leftLabel = new JLabel[name.length];
		JTextField[] center = new JTextField[name.length];
		String[] unit = {" cm", " kg"};
		JLabel[] rightLabel = new JLabel[unit.length];
		JButton btn;
		BMIVO vo;
		
	JPanel bottomPanel;
		JLabel checklbl;
	
	
	public BMIView() {
		infoPanel = new JPanel();
		infoLabel = new JLabel(title);
		setPanel = new JPanel(new GridLayout(3,3));

		int count = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < 6; i++ ) {
			switch (i) {
			case 0 : case 3 : 
				leftLabel[count] = new JLabel(name[count]);
				setPanel.add(leftLabel[count]);
				count++;
				break;
			case 1 : case 4 :
				center[count1] = new JTextField("34");
				setPanel.add(center[count1]);
				count1++;
				break;
			case 2 : case 5 :
				rightLabel[count2] = new JLabel(unit[count2]);
				setPanel.add(rightLabel[count2]);
				count2++;
				break;
			}
		}

		btn = new JButton("결과확인");
		for (int i = 0; i < 3; i++) {
			if (i == 1) {
				setPanel.add(btn);
			} else {
				setPanel.add(new JLabel(" "));
			}
		}
		
		infoPanel.add(infoLabel);
		add(infoPanel, BorderLayout.NORTH);
		add(setPanel, BorderLayout.CENTER);
		infoPanel.setBackground(Color.WHITE);
		setPanel.setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		
	}
	public JButton getBtn() {
		return btn;
	}
	public BMIVO neededInsertData() {
		BMIVO vo = new BMIVO();
		
		vo.setTall(Double.parseDouble(center[0].getText()));
		vo.setWeight(Double.parseDouble(center[1].getText()));
		vo.getBMI(vo.getTall(), vo.getWeight());
		
		return vo;
	}
	public void initInsertData() {
		for (int i = 0; i < center.length; i++ ) {
			center[i].setText("");
			
		}
	}
	

}
