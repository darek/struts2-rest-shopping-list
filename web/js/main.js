/** main.js **/

function initAddProductForm(){
	var form = $("form#add-product-form");
	var submit = form.find("#add-product-form_0");
	var name = form.find("#add-product-form_product_name");
	var amount = form.find("#add-product-form_product_amount");
	
	$("form#add-product-form").submit(function(){
	   submit.addClass("disable");
	   submit.attr("disabled","disabled");
		$.ajax({
	 		type: "post",
	 		data: {"product.name":name.val(),"product.amount":amount.val()}
	 	})
	 	.success(function(){
	 		console.log("suc");
	 	})
	 	.error(function(){
	 		console.log("err");
	 	})
	 	.complete(function(){
	 		name.val("");
	 		amount.val(0);
	 		submit.removeAttr("disabled");
			submit.removeClass("disable");
	 	});
	 	submit.removeAttr("disabled");
	 	submit.removeClass("disable");
	 	return false;
		
	});

}