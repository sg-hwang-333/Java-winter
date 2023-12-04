package bmi.vo;

import javax.swing.ImageIcon;

public class BMIDAO {
	
	public String bmiValue(double bmi) {
		int div = 0;
		String str = "";
		if (bmi >= 35.0) {
			div = 5;
		} else if (bmi >= 30) {
			div = 4;
		}else if (bmi >= 25.0) {
			div = 3;
		} else if (bmi >= 18.5 ) {
			div = 2;
		} else {
			div = 1;
		}
		switch(div) {
		case 1 : str = "저체중"; break;
		case 2 : str = "정상 체중"; break;
		case 3 : str = "과체중"; break;
		case 4 : str = "비만"; break;
		case 5 : str = "고도비만"; break;
		}
		return str;
	}
	
	public ImageIcon bmiImage(String bmiValue) {
		ImageIcon img = null;
		switch (bmiValue) {
		case "저체중" : img = new ImageIcon("image/저체중.PNG"); break;
		case "정상 체중" : img = new ImageIcon("image/표준.PNG"); break;
		case "과체중" : img = new ImageIcon("image/과체중.PNG"); break;
		case "비만" : img = new ImageIcon("image/비만.PNG"); break;
		case "고도비만" : img = new ImageIcon("image/고도비만.PNG"); break;
		}
		
		return img;
	}
}
