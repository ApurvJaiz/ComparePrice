package Entities;

public class Product 
{
	String price,product,name,image,url;
	
	public Product() {
		super();
		this.price = "NA";
		this.product = "NA";
		this.name = "NA";
		this.image="NA";
		this.url="NA";
	}
	public Product(String price, String product, String name,String image,String url) {
		super();
		this.price = price;
		this.product = product;
		this.name = name;
		this.image=image;
		this.url=url;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
