package info.lavenderdawn.dto;

public interface CollectionProduct {
	
	// used to tell DTO to populate w/t data coming from table in query
		public String getCategory();
		public String getName();
		public String getBrand();
		public String getColor();
		public String getCost();
		public String getAmount();
		public String getRating();
}
