package info.lavenderdawn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="product_id")
	private long productId;
	
	@NotNull
	@Size(min=1, max=50)
	private String name;
	
	@NotNull
	@Size(min=1, max=50)
	private String brand;
	
	@NotNull
	@Size(min=1, max=50)
	private String color;
	
	private double cost;
	
	private int amount;
	
	private int rating;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			   fetch = FetchType.LAZY)
	@JoinTable(name="collection_product",
	joinColumns=@JoinColumn(name="product_id"),
	inverseJoinColumns=@JoinColumn(name="collection_id")
	)
	@JsonIgnore
	private List<Collection>collections;
	
	public Product() {
		
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public Product(@NotNull @Size(min = 1, max = 50) String name, @NotNull @Size(min = 1, max = 50) String brand,
			@NotNull @Size(min = 1, max = 50) String color, double cost, int amount, int rating,
			List<Collection> collections) {
		super();
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.cost = cost;
		this.amount = amount;
		this.rating = rating;
		this.collections = collections;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", brand=" + brand + ", color=" + color
				+ ", cost=" + cost + ", amount=" + amount + ", rating=" + rating + ", collections=" + collections + "]";
	}

	
}