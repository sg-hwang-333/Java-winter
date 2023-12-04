package product.vo;

import java.util.ArrayList;


public class ProductDAO {
	ArrayList<ProductVO> productList= new ArrayList<ProductVO>();
	
	public void insert(ProductVO vo) {
		productList.add(vo);
	}
	public void addStock(ProductVO vo, int count) {
		vo.setTotalStock(count);
	}
	public void buystock(ProductVO vo) {
		vo.setTotalStock(vo.getTotalStock()-1);
	}
	public ArrayList<ProductVO> select() {
		return productList;
	}

}
