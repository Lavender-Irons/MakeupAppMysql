CREATE TABLE IF NOT EXISTS collections(
	collection_id INT NOT NULL PRIMARY KEY,
	category VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS products(
	product_id INT NOT NULL PRIMARY KEY,
	name VARCHAR(100),
	brand VARCHAR(100),
	color VARCHAR(100),
	cost INT,
	amount INT,
	rating INT,
	collection_id INT,
	FOREIGN KEY(collection_id) 
REFERENCES collections(collection_id)
);

