var string = {
	coffee: "",
	size: "",
	condiments: "",
	price: "",
	largeSize : "",
	norrmalSize : "",
	confirmBody : "",
	invalidPrice : "",
	emptyOrder : "",
	inputError : "",
	existName : "",
	connectDB: "",
	confirmAddUser: "",
	confirmUnlockUser: "",
	confirmLockUser: "",
	confirmAddCoffee: "",
	confirmUpdateCoffee: "",
	confirmAddCondiment: "",
	confirmUpdateCondiment: "",
	success : "",
	wrongCur : "",
	wrongRepeat : "",
	emptyField : ""
}

function setLanguage(lang) {
	switch (lang) {
	case "jp":
		string.coffee = "コーヒー";
		string.size = "サイズ";
		string.condiments = "調味料";
		string.price = "価格";
		string.largeSize = "大きい";
		string.normalSize =	"普通";
		string.confirmBody = "あなたはこの注文を提出しますか？";
		string.invalidPrice = "合計が間違い";
		string.emptyOrder = "何も注文しなかった。";
		string.inputError = "入力が必要です";
		string.existName = "この名は使用中";
		string.connectDB = "データベースに接続できません";
		string.confirmAddUser = "このユーザーを追加しますか？";
		string.confirmUnlockUser = "このユーザーをアンロックしますか？";
		string.confirmLockUser = "このユーザーをロックしますか？";
		string.confirmAddCoffee = "このコーヒーを追加しますか？";
		string.confirmUpdateCoffee = "このコーヒーを更新しますか？";
		string.confirmAddCondiment = "この調味料aを追加しますか？";
		string.confirmUpdateCondiment = "この調味料を更新しますか？";
		string.success = "成功した！！！";
		string.wrongCur = "現在パスワードが間違った";
		string.wrongRepeat = "確認パスワードが間違った";
		string.emptyField = "入力情報は足りなかった";
		break;
	case "vi":
		string.coffee = "Cà phê";
		string.size = "Cỡ";
		string.condiments = "Đi kèm";
		string.price = "Giá";
		string.largeSize = "Lớn";
		string.normalSize =	"Thường";
		string.confirmBody = "Bạn có muốn duyệt đơn hàng này?";
		string.invalidPrice = "Tổng giá không hợp lệ";
		string.emptyOrder = "Đơn hàng không hợp lệ";
		string.inputError = "Thông tin không hợp lệ";
		string.existName = "Tên này đã tồn tại";
		string.connectDB = "Không thể kết nối đến cơ sở dữ liệu";
		string.confirmAddUser = "Bạn có muốn thêm người dùng này?";
		string.confirmUnlockUser = "Bạn có muốn kích hoạt tài khoản này?";
		string.confirmLockUser = "Bạn có muốn khóa tài khoản này?";
		string.confirmAddCoffee = "Bạn có muốn thêm cà-phê này?",
		string.confirmUpdateCoffee = "Bạn có muốn cập nhật loại cà-phê này?";
		string.confirmAddCondiment = "Bạn có muốn thêm condiment này?",
		string.confirmUpdateCondiment = "Bạn có muốn cập nhật loại condiment này?";
		string.success = "Thành công!!!";
		string.wrongCur = "Mật khẩu hiện tại không đúng!";
		string.wrongRepeat = "Mật khẩu xác nhận không khớp!";
		string.emptyField = "Còn thông tin chưa được điền!";
		break;
	default:
		string.coffee = "Coffee";
		string.size = "Size";
		string.condiments = "Condiments";
		string.price = "Price";
		string.largeSize = "Large";
		string.normalSize =	"Normal";
		string.confirmBody = "Are You Sure You Want to Accept this Order";
		string.invalidPrice = "Invalid order price";
		string.emptyOrder = "This order is empty";
		string.inputError = "Input Error";
		string.existName = "This already in use";
		string.connectDB = "Cannot connect to Database";
		string.confirmAddUser = "Are you sure you want to add this user?";
		string.confirmUnlockUser = "Are you sure you want to unlock this user?";
		string.confirmLockUser = "Are you sure you want to lock this user?";
		string.confirmAddCoffee = "Are you sure you want to add this coffee?",
		string.confirmUpdateCoffee = "Are you sure you want to update this coffee?";
		string.confirmAddCondiment = "Are you sure you want to add this condiment?",
		string.confirmUpdateCondiment = "Are you sure you want to update this condiment?";
		string.success = "Success!!!";
		string.wrongCur = "Current Password is wrong!";
		string.wrongRepeat = "Repeat Password is not match!";
		string.emptyField = "Some fields are empty!";
		break;
	}
}