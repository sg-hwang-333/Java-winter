package bmi.vo;

public class BMIVO {
	double weight;
	double tall;
	double BMI;
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getTall() {
		return tall;
	}
	public void setTall(double tall) {
		this.tall = tall;
	}
	public double getBMI(double weight, double tall) {
		return weight / Math.pow(tall/100, 2); 
	}	
	public double findBMI() {
		return BMI;
	}
	public void setBMI(double BMI) {
		this.BMI = BMI;
	}
	
	public BMIVO() {}
	public BMIVO(double weight, double tall) {
		super();
		this.weight = weight;
		this.tall = tall;
	}
	
	
	
	

}
