package GradedProject3;

public class Product {
	private int prodId;
	private String prodName;
	private double sellingPrice;
	private String category;
	private int availQuantity;
	private double buyingPrice;
	

	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", sellingPrice=" + sellingPrice + ", category="
				+ category + ", availQuantity=" + availQuantity + ", buyingPrice=" + buyingPrice + "]";
	}



	public Product(int prodId, String prodName, double sellingPrice, String category, int availQuantity,double buyingprice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.availQuantity = availQuantity;
		this.buyingPrice = buyingPrice;
	}



	public int getProdId() {
		return prodId;
	}



	public void setProdId(int prodId) {
		this.prodId = prodId;
	}



	public String getProdName() {
		return prodName;
	}



	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



	public double getSellingPrice() {
		return sellingPrice;
	}



	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}


 
	
	public int getAvailQuantity() {
		return availQuantity;
	}



	public void setAvailQuantity(int availQuantity) {
		this.availQuantity = availQuantity;
	}



	public double getBuyingprice() {
		return buyingPrice;
	}



	public void setBuyingprice(double buyingprice) {
		this.buyingPrice = buyingprice;
	}


	 
	
}



