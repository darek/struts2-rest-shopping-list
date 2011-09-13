<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html> 
	<html> 
	<head> 
		<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
		<title>Shopping list - ${list.name}</title> 
		<link rel="stylesheet" href="/css/system.css" type="text/css" />
		<script type="text/javascript">
			ContextPath = "${pageContext.request.contextPath}";
		</script>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.js"></script> 
	</head> 
	<body> 

	<h2>Products list
		<a href="#" onclick="deleteList('${list.id}')">delete list</a>	
	</h2>
	<form action="" method="post" id="add-product-form">
		<input type="text" name="product.name" id="product-name" placeholder="Product name" required="required" />
		<input type="text" name="product.amount" id="product-amount" placeholder="Product amount" min="1" required="required" />
		<input type="submit" value="go" />
	</form>
	
	<ol id="products-list">
		<s:iterator value="list.productsList">
			<li><s:property value="name" /> (<s:property value="amount" />) <a href="#" id="<s:property value="id" />">X</a></li>
		</s:iterator>
	</ol>

	<script type="text/javascript">
		$(document).ready(function(){
			initAddProductForm('<s:property value="id" />');
			bindDeleteProductsLinks('<s:property value="id" />');
		});
	</script>
</body> 
</html> 