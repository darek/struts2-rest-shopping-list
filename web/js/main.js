/** main.js **/

function bindAddShoppingListForm(){
	var form = $("form#add-shopping-list");
	form.submit(function(){
		var name = form.find("#name").val();
		if(name.length>0){
			$.post(ContextPath+"/shopping-list.json",
				   {"list.name":name},
				   function(data,status,xhr){
					   var location = xhr.getResponseHeader('Location');
					   if(location.length>0){
						   location = location.substr(0,location.lastIndexOf('.') + 1)+"xhtml";
						   redirect(location,true);
					   }else{
						   
					   }
				       return false;
				   },
				   'json');
		}else{
			
		}
		return false;
	});
}

function initAddProductForm(id){
	var form = $("form#add-product-form");
	var submit = form.find("#add-product-form_0");
	var name = form.find("#product-name");
	var amount = form.find("#product-amount");
	
	$("form#add-product-form").submit(function(){
	   submit.addClass("disable");
	   submit.attr("disabled","disabled");
	   $.ajax({
			url: ContextPath+"/product.json",
	 		type: "post",
	 		data: {"id":id,"product.name":name.val(),"product.amount":amount.val()},
			statusCode:{
				204: function(){
					redirect("/shopping-list/"+id+".xhtml");
				}
			}
	 	})
	 	.success(function(){
	 		redirect("/shopping-list/"+id+".xhtml");
	 	})
	 	.error(function(){
	 		$("#window").dialog({
	 			modal: true,
	 			closeOnEscape: false,
	 			buttons: {
					Ok: function() {
						$( this ).dialog( "close" );
					}
				}

	 		});
	 	})
	 	.complete(function(){
	 		name.val("");
	 		amount.val(0);
	 		submit.removeAttr("disabled");
			submit.removeClass("disable");
			submit.removeAttr("disabled");
		 	submit.removeClass("disable");
	 	});
	 	return false;
		
	});

}

function deleteList(id){
	$.ajax({
		url: ContextPath+"/shopping-list/"+id+".json",
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
 		url: ContextPath+"/product/"+id+".json?productId="+pid,
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

function redirect(url,full){
	if(full==true){
		window.location.href=url;
	}else{
		window.location.href=ContextPath+"/"+url;
	}
}
