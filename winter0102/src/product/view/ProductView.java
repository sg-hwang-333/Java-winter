package product.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import product.vo.ProductVO;


public class ProductView{
	ArrayList<ProductVO> productList;	
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	
	public JPanel displayProducts() {
		JPanel panC = new JPanel(new GridLayout(3,3));
		for (ProductVO vo : productList) {
			ImageIcon icon = new ImageIcon("Images/" + vo.getImageName()+".PNG");
			JLabel lbl = new JLabel(icon);
			lblList.add(lbl);
			panC.add(lbl);
		}
		return panC;
	}
	public void inputPurchase() {
		
	}
	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}
}
