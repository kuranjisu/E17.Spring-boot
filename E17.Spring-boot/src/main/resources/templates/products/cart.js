




    let increment  =  document.getElementById("increment");
    let decrement  =  document.getElementById("decrement");
    let finalQuantity = 0;

    increment.addEventListener("click", function(){


    let currQuantity =  parseFloat(document.querySelector(".quantity").value);
    console.log(currQuantity+" current quantity");
    console.log(finalQuantity+" final quantity");



    if(currQuantity<finalQuantity){
    currQuantity = currQuantity+1;
    document.querySelector(".quantity").value = currQuantity;
}

});



    decrement.addEventListener("click", function(){


    let currQuantity =  parseFloat(document.querySelector(".quantity").value);
    console.log(currQuantity+" current quantity");
    console.log(finalQuantity+" final quantity");



    if(currQuantity>1){
    currQuantity = currQuantity-1;
    document.querySelector(".quantity").value = currQuantity;
}

});







    $('.addB').on('click', function() {
    var productName = $(this).siblings('.w2').find('.pname').text();
    var productId = $(this).siblings('.w2').find('.pid').text();
    var price = $(this).siblings('.w2').find('.pprice label').text();
    var quantity = $(this).siblings('.w2').find('.pquantity label').text();

    let newText = parseFloat(price.replace("PRICE: ", ""));
    finalQuantity = parseFloat(quantity.replace("QUANTITY: ", ""));





    console.log(productName);
    console.log(productId);
    console.log(newText);
    console.log(quantity);

    document.querySelector(".productId").value = productId;
    document.querySelector(".productName").value = productName;
    document.querySelector(".price").value = newText;
    document.querySelector(".quantity").value = 1;


    myDiv.style.width = "max-content";
    myDiv.style.height = "max-content";

    console.log(finalQuantity);
    if(finalQuantity<1){
    console.log("dumaan")
    document.getElementById("cart").disabled = true;
    document.getElementById("increment").disabled = true;
    document.getElementById("decrement").disabled  = true;
    document.querySelector(".quantity").value = 0;
}
    else {

    console.log("dumaan")
    document.getElementById("cart").disabled = false;
    document.getElementById("increment").disabled = false;
    document.getElementById("decrement").disabled  = false;
    document.querySelector(".quantity").value = 1;


}



});

















    let total;

    let addToCartButton= document.getElementById("cart");
    addToCartButton.addEventListener("click", function(){
    // productId, productName, price, quantity
    let productId = document.getElementById("productId").value;
    let productName = document.getElementById("productName").value;
    let price = document.getElementById("price").value;
    let quantity = document.getElementById("quantity").innerHTML;
    //  total = quantity*price;


    let table = document.getElementById("myTable1");

// Create a new row element
    let newRow = document.createElement("tr");

// Create new cells for the new row
    let  idCell = document.createElement("td");
    let nameCell = document.createElement("td");
    let priceCell = document.createElement("td");
    let  quantityCell = document.createElement("td");
    let  totalCell = document.createElement("td");

// Set the text of the cells
    idCell.innerHTML = "1";
    nameCell.innerHTML = "Product 1";
    priceCell.innerHTML = "$10";
    quantityCell.innerHTML = "5";
    totalCell.innerHTML = "$50";
    newRow.appendChild(idCell);
    newRow.appendChild(nameCell);
    newRow.appendChild(priceCell);
    newRow.appendChild(quantityCell);
    newRow.appendChild(totalCell);

// Append the new row to the table
    table.appendChild(newRow);


    alert(idCell.innerHTML)


});



















    let navbar = document.getElementById("navbar");
    let menuicon = document.getElementById("span1");




    menuicon.onclick = function(){


    let box = document.querySelector('.navbar');
    let width = box.offsetWidth;


    if(width>1){
    navbar.style.width = "0";
    menuicon.innerHTML = "shopping_cart";

}
    else{
    navbar.style.width = "30vw";
    menuicon.innerHTML = "close";
}


}








    let task = document.getElementById("task");

    function checker(){

    let productName= document.querySelector("#productName1").value;
    let price = document.querySelector("#price1").value;
    let quantity = document.querySelector("#quantity1").value;
    let imageUrl = document.querySelector("#imageUrl1").value;



    if( productName== ""  ){
    alert("input field is missing!")
}
    else if(price == ""  ){
    alert("input field is missing!")
}
    else if(quantity == ""  ){
    alert("input field is missing!")
}
    else if(imageUrl == ""  ){
    alert("input field is missing!")
}


    else{
    alert("product Added !")
}

}




    let myDiv = document.getElementById("myDiv");
    let mySpan = document.getElementById("span");


    mySpan.addEventListener("click", function() {

    myDiv.style.width = "0px";
    myDiv.style.height = "0px";

});










