var global;

function Cup(id,orderId,size,coffee,price) {
	this.cupId = id;
	this.orderId = orderId;
	this.size = size;
	this.coffee = coffee;
	this.condiments = [];
	this.price = price;
};

Cup.prototype.setCoffee = function(coffee) {
	this.coffee = coffee;
}

Cup.prototype.setSize = function(size) {
	this.size = size;
}

Cup.prototype.setCondiments = function(condiments) {
	for(key in condiments) {
		this.condiments.push(condiments[key]);	
	}
	global = this.condiments;
}

Cup.prototype.getCondimentsName = function() {
	var res = "";
	function makeStr(value) {
		if(res=="") res += value.name;
		else res += (", " + value.name);
	}
	global.forEach(makeStr);
	return res; 
}

Cup.prototype.addPrice = function(increment) {
	this.price += parseFloat(increment);
}

Cup.prototype.subPrice = function(decrement) {
	this.price -= parseFloat(decrement);
}