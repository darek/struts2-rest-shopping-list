/** main.js **/

function initAddProductForm(id){
	var form = $("form#add-product-form");
	var submit = form.find("#add-product-form_0");
	var name = form.find("#product-name");
	var amount = form.find("#product-amount");
	
	$("form#add-product-form").submit(function(){
	   submit.addClass("disable");
	   submit.attr("disabled","disabled");
		$.ajax({
			url: ContextPath+"/product",
	 		type: "post",
	 		data: {"id":id,"product.name":name.val(),"product.amount":amount.val()}
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

function deleteList(id){
	console.log("dupa");
	$.ajax({
		url: ContextPath+"/shopping-list/"+id,
		data: {"id":id},
		type: "delete"
	})
	.success(function(){
		
	})
	.error(function(){
		
	})
	.complete(function(){
		
	});
	return false;
}

function bindDeleteProductsLinks(id){
 $("#products-list li a").click(function(){
 	var pid = $(this).attr("id");
 	$.ajax({
 		url: ContextPath+"/product/"+id+"?productId="+pid,
 		type: "delete"
 	})
 	.success(function(){
 		console.log("suc");
 	})
 	.error(function(){
 		console.log("error");
 	})
 	.complete(function(){
 		console.log("compl");
 	});
 		
 		
 		
 	return false;
 	
 });	
}