
//getters and setters


document.addEventListener("DOMContentLoaded", function(event)
{
	var formFull = false;
	document.getElementById("submitButton").addEventListener("click", saveActionClick);
});


function saveActionClick(event)
{
	if(!checkForm())
	{
		return;
	}
	else
	{
		displayError("This is probably not gonna work");
	}
}

function checkForm()
{
	
	const lookupCode = getLookupCode();
	console.log(lookupCode);
	if(lookupCode == null || (lookupCode.trim() == ""))
	{
		displayError("please provide valid lookup code");
		return false
	}

	return true;
}

function getLookupCode()
{
	return getProductLookupCodeElement().value;
}

function getLookupCodeElement()
{
	return document.getElementById("lookupInput");
}

function setLookupCodeElement(lookupCode)
{
	getLookupCodeElement().value = lookupCode;
}

//-------------------------------------------------------------------
//CLICK ON PRODUCT LIST
//-------------------------------------------------------------------

document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;

	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}
});

function findClickedListItemElement(clickedTarget) {
	if (clickedTarget.tagName.toLowerCase() === "li") {
		return clickedTarget;
	} else {
		let ancestorIsListItem = false;
		let ancestorElement = clickedTarget.parentElement;

		while (!ancestorIsListItem && (ancestorElement != null)) {
			ancestorIsListItem = (ancestorElement.tagName.toLowerCase() === "li");

			if (!ancestorIsListItem) {
				ancestorElement = ancestorElement.parentElement;
			}
		}

		return (ancestorIsListItem ? ancestorElement : null);
	}
}

function productClick(event) {
	let listItem = findClickedListItemElement(event.target);

	var amount = prompt("Please enter the amount", "0");
}

