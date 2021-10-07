var grandTotal = 0;
jQuery(document).ready(function(){
	$(window).click(function() {
  	
	});

	$(".cardClick").click(function(){
				
		var item = $(this).find('.name').text();
		var price = $(this).find('.price').text();
		
		$('.tableName').text(item);
		$('.tablePrize').text(price);
		$('#qty').val("0");				
	});   
  
    $('#reset').click(function()
    {
        location.reload();
    });
	
});

function deleterow(e)
    {
        total_cost = parseInt($(e).parent().parent().find('td:last').text(),10);
        grandTotal -= total_cost;
        $('#total').val(grandTotal);
        $(e).parent().parent().remove(); 
    }

function add(e){
		//var item = $(e).closest('.tableName').text();
		//var price = $(e).closest('.tablePrice').text();
		if($('#qty').val()>0){
			var item = document.getElementById("itemName").innerHTML;
			var price = document.getElementById("itemPrice").innerHTML;
			console.log("items" + item +"price" + price);
			var qty = $('#qty').val();
	        itemTotal = qty * price;
	 		grandTotal += itemTotal;
		
	        var table1 =
	 
	            "<tr>" +
	            "<td><button type='button' name='record' class='btn btn-warning' onclick='deleterow(this)'>Delete</td>" +
	            "<td>" + item    +  "</td>" +
	            "<td class='alignRight'>" + price    +  "</td>" +
	 
	            "<td>" + qty    +  "</td>" +
	 
	            "<td class='alignRight'>" + itemTotal    +  "</td>" +
	 
	            "</tr>" ;
	 
	        $('#total').val("$" + grandTotal);
			$('#total').addClass("alignRight");
	  		//$('#qty').val("0");
	        $("#tbl-item tbody").append(table1);
	       	$("#exampleModal").modal('toggle');
		} else {
			alert("Invalid Quantity");
		}
		       
		
	}
	
function updateQty(){
	document.getElementById("itemQty").innerHTML = document.getElementById("qty").value;
}


function print(){
	var total = $('.printBill').val();
	
	$.ajax({
			  url: "/submit",
			  headers: { 
    		    'Accept': 'application/json',
   			  	'Content-Type': 'application/json' 
    		  },
              data: JSON.stringify({total: total}),
			  type: "POST",
	          dataType: 'json',
			success: function(result){
     				if(result == true){
						alert("Thank you shopping with us!");
					}
  				}						  
			});
}

	