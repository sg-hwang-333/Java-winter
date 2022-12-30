package bmi.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bmi.view.BMIView;
import bmi.vo.BMIDAO;
import bmi.vo.BMIVO;

@SuppressWarnings("serial")
public class BMIController extends JFrame{
	BMIView view;
	BMIDAO dao;
	JLabel checklbl;
	JPanel bottomPanel;
	JLabel imglbl;
	
	public BMIController() {
		view = new BMIView();
		JButton btnAdd = view.getBtn();
		bottomPanel = new JPanel();
		checklbl = new JLabel();
		bottomPanel.add(checklbl, BorderLayout.NORTH);
		add(view, "Center");
		add(bottomPanel, BorderLayout.SOUTH);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				BMIVO vo = view.neededInsertData();
				dao = new BMIDAO();
				double bmicheck = vo.getBMI(vo.getWeight(), vo.getTall());
				String bmi = dao.bmiValue(bmicheck);
				checklbl.setText("<html><center>당신의 키는 " + vo.getTall() + "cm 이고, 체중은 " + vo.getWeight() + "kg 이므로" + "<br>"+ " bmi지수는 " + String.format("%.1f",bmicheck) +"kg/m2이며, " + bmi + "입니다.</center></html>");
				imglbl = new JLabel(dao.bmiImage(bmi));
				bottomPanel.add(imglbl, BorderLayout.SOUTH);
				view.initInsertData();
			}
		});
		bottomPanel.setBackground(Color.WHITE);
		setTitle("BMI 구하기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(500,150);
		setSize(400,600);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new BMIController();

	}
	
	

}
