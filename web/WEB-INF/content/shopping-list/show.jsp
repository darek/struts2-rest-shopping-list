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

	<h2>Products lsit</h2>
	<s:form action="/products-list.xhtml" method="post" id="add-product-form">
		<s:textfield name="product.name" />
		<s:textfield name="product.amount" />
		<s:submit />
	</s:form>
	
	<s:if test="%{productsList !=null}">
		<ol id="products-list">
		<s:iterator value="productsList">
			<li><s:property value="name" /> (<s:property value="amount" />) <a href="#" id="<s:property value="id" />">X</a></li>
		</s:iterator>
		</ol>
	</s:if>

	<script type="text/javascript">
		$(document).ready(function(){
			initAddProductForm('<s:property value="id" />');
			bindDeleteProductsLinks('<s:property value="id" />');
			bindDeleteProductsListLink('<s:property value="id" />');
		});
	</script>
</body> 
</html> 