function User(userName,password,role,enabled) {
	this.userName = userName,
	this.password = password,
	this.role = role,
	this.enabled = enabled
}

User.prototype.setUserName = function(userName) {
	this.userName = userName;
}

User.prototype.setPassword = function(newPassword) {
	this.password = newPassword;
}

User.prototype.setRole = function(role) {
	this.role = role;
}

User.prototype.setEnabled = function(enabled) {
	this.enabled = enabled;
}