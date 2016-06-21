function Order(orderId,seller,purchaseTime,cups,total) {
	this.orderId = orderId,
	this.seller = seller,
	this.purchaseTime = purchaseTime,
    this.cups = cups,
	this.total = total
}

Order.prototype.addCup = function(cup) {
	this.cups.push(cup);
} 

Order.prototype.addTotal = function(increment) {
	this.total += parseFloat(increment);
}