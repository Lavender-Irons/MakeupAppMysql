package info.lavenderdawn.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="shopping")
public class Shopping {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="shopping_id")
	private long shoppingId;
	
	@NotNull
	@Size(min=1, max=50)
	private String category;
	
	@NotNull
	@Size(min=1, max=50)
	private String name;
	
	@NotNull
	@Size(min=1, max=50)
	private String brand;
	
	@NotNull
	@Size(min=1, max=50)
	private String color;
	
	private int cost;
	
	private int amount;
	
	@Temporal(TemporalType.DATE)
	private Date bought;
	
	private boolean purchased;
	
	public Shopping() {
		
	}
	


	
	public long getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(long shoppingId) {
		this.shoppingId = shoppingId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getBought() {
		return bought;
	}

	public void setBought(Date bought) {
		this.bought = bought;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public Shopping(@NotNull @Size(min = 1, max = 50) String category, @NotNull @Size(min = 1, max = 50) String name,
			@NotNull @Size(min = 1, max = 50) String brand, @NotNull @Size(min = 1, max = 50) String color, int cost,
			int amount, Date bought, boolean purchased) {
		super();
		this.category = category;
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.cost = cost;
		this.amount = amount;
		this.bought = bought;
		this.purchased = purchased;
	}

	
}	