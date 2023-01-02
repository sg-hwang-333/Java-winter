package product.controller;

import java.util.ArrayList;

import javax.swing.*;

import product.view.ProductView;
import product.vo.ProductDAO;
import product.vo.ProductVO;

@SuppressWarnings("serial")
public class ProductController extends JFrame {
	ArrayList<ProductVO> productList;
	
	public ProductController() {
		ProductView view = new ProductView();
		fullProduct();
		view.setProductList(productList);
		JPanel panC = view.displayProducts();
		add(panC, "Center");
		
		setTitle("음료자판기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(150,10,600,600); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new ProductController();

	}
	
	public void fullProduct() {
		//자판기에 제품 채우기
		ProductDAO dao = new ProductDAO();
		String[] names = {"딸기라떼", "망고", "몬스터", "밀키스", "봉봉", "사이다", "옥수수수염차","콜라","핫식스"};
		int[] prices = {1100, 1000, 1500, 1000, 500, 1300, 1800, 1300, 1200};
		ProductVO vo = null;
		productList = dao.select();
		for (int i = 0; i < names.length; i++) { 
			vo = new ProductVO();
			vo.setName(names[i]);
			vo.setPrice(prices[i]);
			vo.setProductNum(10);
			vo.setImageName(names[i]);
			productList.add(vo);
			
		}
	}

}
