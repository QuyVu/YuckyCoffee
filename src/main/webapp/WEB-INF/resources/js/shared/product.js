function Product(id,name,price,enabled) {
	this.id = id;
	this.name = name;
	this.price = price;
	this.enabled = enabled;
}

Product.prototype.setProduct = function(id, name, price) {
	this.id = id;
	this.name = name;
	this.price = parseFloat(price);
}

Product.prototype.setId = function(id) {
	this.id = id;
}

Product.prototype.setName = function(name) {
	this.name = name;
}

Product.prototype.setPrice = function(price) {
	this.price = price;
}