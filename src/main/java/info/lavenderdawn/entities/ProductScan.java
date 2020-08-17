package info.lavenderdawn.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_scan")
public class ProductScan {

	@Id
	private String id;
	private String name;
	private double price;
	private int quantity;
	private boolean status;
	
	public ProductScan() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ProductScan(String name, double price, int quantity, boolean status) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	
}
