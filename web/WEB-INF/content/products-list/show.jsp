<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html> 
	<html> 
	<head> 
		<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
		<title>Add product to list</title> 
		<link rel="stylesheet" href="/css/system.css" type="text/css" />
		<script type="text/javascript">
			ContextPath = "<s:url value="/" />";
		</script>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.js"></script> 
	</head> 
	<body> 

	<h2>Lista produktów</h2>%{id}
	<s:form action="/products-list.xhtml" method="post" id="add-product-form">
		<s:textfield name="product.name" />
		<s:textfield name="product.amount" />
		<s:submit />
	</s:form>
	
	<s:if test="%{#productsList !=null and #productsList.size()>0}">
		<ul>
		<s:iterator id="product" value="productsList">
			<li><s:property value="name" /> <a href="/delete/<s:property value="id" />.html">x</a></li>
		</s:iterator>
		<li><s:form action="/add.html"><s:textfield name="productName" /></s:form></li>
		</ul>
	</s:if>

	<script type="text/javascript">
		$(document).ready(function(){
			initAddProductForm('<s:property value="id" />');
		});
	</script>
</body> 
</html> 