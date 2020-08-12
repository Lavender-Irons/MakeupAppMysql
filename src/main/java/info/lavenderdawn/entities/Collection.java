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
@Table(name="collection")
public class Collection {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="collection_id")
	private long collectionId;
	
	@NotNull
	@Size(min=1, max=50)
	@Column(unique=true)
	private String category;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="collection_product",
			joinColumns=@JoinColumn(name="collection_id"),
			inverseJoinColumns=@JoinColumn(name="product_id") 
	)
	@JsonIgnore
	private List<Collection>collections;
	
	
	public Collection() {
		
	}

	public long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public Collection(String category, List<Collection> collections) {
		super();
		this.category = category;
		this.collections = collections;
	}

	@Override
	public String toString() {
		return "Collection [collectionId=" + collectionId + ", category=" + category + ", collections=" + collections
				+ "]";
	}
	
	
}
