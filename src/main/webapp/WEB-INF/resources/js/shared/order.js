function Order(orderId,seller,purchaseTime,total) {
	this.orderId = orderId,
	this.seller = seller,
	this.purchaseTime = purchaseTime,
    this.cups = [],
	this.total = total
}

Order.prototype.addCup = function(cup) {
	this.cups.push(cup);
}

Order.prototype.setTime = function(pTime) {
	this.purchaseTime = pTime;
}

Order.prototype.setSeller = function(seller) {
	this.seller = seller;
}

Order.prototype.addTotal = function(increment) {
	this.total += parseFloat(increment);
}