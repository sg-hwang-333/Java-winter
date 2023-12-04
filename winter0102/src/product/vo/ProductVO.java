package product.vo;

public class ProductVO {
	private String name;
	private int price;
	private int productNum;
	private int totalStock;
	private String ImageName;
	
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
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getImageName() {
		return ImageName;
	}
	public void setImageName(String imageName) {
		ImageName = imageName;
	}
	
	public ProductVO() {}
	public ProductVO(String name, int price, int productNum, int totalStock, String imageName) {
		super();
		this.name = name;
		this.price = price;
		this.productNum = productNum;
		this.totalStock = totalStock;
		ImageName = imageName;
	}
	

}
