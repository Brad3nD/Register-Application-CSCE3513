document.addEventListener("DOMContentLoaded", function(event) {
	getStartTransactionActionElement().addEventListener(
		"click",
		() => { window.location.assign("/transaction"); });

	getViewProductsActionElement().addEventListener(
		"click",
		() => { window.location.assign("/productListing"); });

	getCreateEmployeeActionElement().addEventListener(
		"click",
		() => { window.location.assign("/employeeDetail"); });

	getProductSalesReportActionElement().addEventListener(
		"click",
		() => { window.location.assign("/productSales"); });

	getCashierSalesReportActionElement().addEventListener(
		"click",
		() => { window.location.assign("/cashierSales"); });
});

// Getters and setters
function getViewProductsActionElement() {
	return document.getElementById("viewProductsButton");
}

function getCreateEmployeeActionElement() {
	return document.getElementById("createEmployeeButton");
}

function getStartTransactionActionElement() {
	return document.getElementById("startTransactionButton");
}

function getProductSalesReportActionElement() {
	return document.getElementById("productSalesReportButton");
}

function getCashierSalesReportActionElement() {
	return document.getElementById("cashierSalesReportButton");
}
// End getters and setters
