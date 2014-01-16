
var appPath = "/LibraryTest1";

function loan_item() {
	var userID = prompt('Enter the user ID.');
	if(userID==null) return;
	
	var barcode = prompt('Enter barcode of the item.');
	if(barcode==null) return;	
	
	if(userID != "" && barcode != "") {
		window.location = appPath + "/loan_item/" + barcode + "/" + userID;
	}
}

function reserve_item() {
	var userID = prompt('Enter the user ID.');
	if(userID==null) return;
	
	var barcode = prompt('Enter barcode of the item.');
	if(barcode==null) return;
	
	if(userID != "" && barcode != "") {
		window.location = appPath + "/loan_item/" + barcode + "/" + userID;
	}
}

function goToWelcomePage() {
	window.location = '/LibraryTest1/welcome';
}
