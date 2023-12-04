package product.vo;

public class ProductVO {
	private String name;
	private int price;
	private int totalStock;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
	
	public ProductVO() {}
	public ProductVO(String name, int price, int totalStock) {
		super();
		this.name = name;
		this.price = price;
		this.totalStock = totalStock;
	}
	
	
	

}
