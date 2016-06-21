function Cup(id,orderId,size,coffee,condiments,price) {
	this.cupId = id,
	this.orderId = orderId,
	this.size = size,
	this.coffee = coffee, 
	this.condiments = condiments, 
	this.price = price
};

Cup.prototype.setCoffee = function(coffee) {
	this.coffee = coffee;
}

Cup.prototype.setSize = function(size) {
	this.size = size;
}

Cup.prototype.addPrice = function(increment) {
	this.price += parseFloat(increment);
}

Cup.prototype.subPrice = function(decrement) {
	this.price -= parseFloat(decrement);
}