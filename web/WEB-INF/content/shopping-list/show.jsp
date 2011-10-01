<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html> 
	<html> 
	<head> 
		<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
		<title>Shopping list - ${list.name}</title> 
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flick/jquery-ui.css" type="text/css" />
		<script type="text/javascript">
			ContextPath = "${pageContext.request.contextPath}";
		</script>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.js"></script> 
	</head> 
	<body> 
	<h1>Shopping list</h1>
	
	<h2>Products list  - 
		<span>${list.name}</span>
	</h2>
	<a href="#" class="delete-list button ui-icon ui-icon-closethick" onclick="deleteList('${list.id}')">delete list</a>
	
	<aside id="list-info" class="box">
		<p>ID: <span class="bold small">${list.id}</span></p>
		<p>URL:
			<s:a action="shopping-list/%{list.id}.xhtml" forceAddSchemeHostAndPort="true" includeContext="true">
				<span class="bold small"><s:url action="shopping-list/%{list.id}.xhtml" forceAddSchemeHostAndPort="true" /></span>
			</s:a>
		</p>
	</aside>
	
	<aside id="shopping-list"  class="box">
		
		<s:a value="/shopping-list/%{list.id}.json" forceAddSchemeHostAndPort="true" includeContext="true" cssClass="file"><span class="ui-icon ui-icon-document-b"></span>json</s:a>
		<s:a value="/shopping-list/%{list.id}.xml" forceAddSchemeHostAndPort="true" includeContext="true" cssClass="file"><span class="ui-icon ui-icon-document-b"></span>xml</s:a>
		
		<form action="" method="post" id="add-product-form">
			<input type="text" name="product.name" id="product-name" placeholder="Product name" required="required" />
			<input type="text" name="product.amount" id="product-amount" placeholder="Product amount" min="1" required="required" />
			<input type="submit" value="go" />
		</form>
		
		<ol id="products-list">
			<s:iterator value="list.productsList" var="l" >
				<li>${l.name} (${l.amount}) <a href="#" class="ui-icon ui-icon-trash" id="${l.id}">X</a></li>
			</s:iterator>
		</ol>
	</aside>

	<div id="window" title="Info" style="display:none">
		<div class="content">
		
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			initAddProductForm('<s:property value="id" />');
			bindDeleteProductsLinks('<s:property value="id" />');
		});
	</script>
	
	<footer>
			<p>&copy; by <a href="http://darekzon.com">darek zon</a></p>
			<p><a href="http://www.colourlovers.com/pattern/50713/pat">pattern</a> by <a href="http://www.colourlovers.com/lover/florc">florc</a> from <a href="http://www.colourlovers.com/lover/florc">colurlovers</a></p> 
	</footer>
	
</body> 
</html> 