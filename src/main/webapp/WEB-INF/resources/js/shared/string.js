var string = {
	normalSize : "",
	largeSize : "",
	confirmModalHeader : "",
	confirmBody : "",
	yesButton : "",
	noButton : "",
	responseHeader : "",
	responseBody : "",
	closeButton : "",
	updatePassHeader : "",
	curPass : "",
	newPass : "",
	repeatPass : "",
	emptyField : "",
	wrongCur : "",
	wrongRepeat : "",
	success : ""
}
function setLanguage(lang) {
	switch (lang) {
	case "jp":
		string.normalSize = "通常";
		string.largeSize = "大きい";
		string.confirmModalHeader = "確認";
		string.confirmBody = "あなたはこの注文を提出しますか？";
		string.yesButton = "はい";
		string.noButton = "いいえ";
		string.responseHeader = "お知らせ";
		string.responseBody = "";
		string.closeButton = "閉じる";
		string.updatePassHeader = "パスワード更新";
		string.curPass = "当座パスワード";
		string.newPass = "新規パスワード";
		string.repeatPass = "確認パスワード";
		string.emptyField = "空いフィールドがある";
		string.wrongCur = "当座パスワードが間違った";
		string.wrongRepeat = "確認パスワードが間違った";
		string.success = "成功した！！！";
		break;
	case "vi":
		string.normalSize = "Vừa";
		string.largeSize = "Lớn";
		string.confirmModalHeader = "Xác nhận";
		string.confirmBody = "Bạn có muốn duyệt đơn hàng này?";
		string.yesButton = "Có";
		string.noButton = "Không";
		string.responseHeader = "Phản hồi";
		string.responseBody = "";
		string.closeButton = "Đóng";
		string.updatePassHeader = "Đổi mật khẩu";
		string.curPass = "Mật khẩu hiện tại";
		string.newPass = "Mật khẩu mới";
		string.repeatPass = "Xác nhận mật khẩu mới";
		string.emptyField = "Có thông tin chưa được nhập!";
		string.wrongCur = "Mật khẩu hiện tại không đúng";
		string.wrongRepeat = "Mật khẩu xác nhận không đúng";
		string.success = "Thành công!";
		break;
	default:
		string.normalSize = "Normal";
		string.largeSize = "Large";
		string.confirmModalHeader = "Confirm";
		string.confirmBody = "Are You Sure You Want to Accept this Order";
		string.yesButton = "Yes";
		string.noButton = "No";
		string.responseHeader = "Response";
		string.responseBody = "";
		string.closeButton = "Close";
		string.updatePassHeader = "Change Password";
		string.curPass = "Current Password";
		string.newPass = "New Password";
		string.repeatPass = "Repeat Password";
		string.emptyField = "Some fields are empty";
		string.wrongCur = "Current Password is incorrect";
		string.wrongRepeat = "Repeat Password is not match";
		string.success = "Success!!!";
		break;
	}
}