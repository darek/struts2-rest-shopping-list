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
		<script type="text/javascript">
			$(document).ready(function(){
				bindAddShoppingListForm();
			});
		</script> 
	</head> 
	<body> 
	<h1>Shopping list</h1>
	
	<aside class="panel left box">
		<h2>Open shopping list</h2>
		<form id="open-shopping-list">
			<input id="code" name="id" placeholder="Shopping List ID" required="required" />
			<input type="submit" value="go" name="" />
		</form>
	</aside>
	
	<aside class="panel right box">
		<h2>Add shopping list</h2>
		<form id="add-shopping-list" method="post" action="${pageContext.request.contextPath}/shopping-list.xhtml">
			<input type="text" placeholder="Shopping list name" id="name" name="list.name" required="required" />
			<input type="submit" value="go" />
		</form>
	</aside>
	
	<footer>
			<p>&copy; by <a href="http://darekzon.com">darek zon</a></p>
			<p><a href="http://www.colourlovers.com/pattern/50713/pat">pattern</a> by <a href="http://www.colourlovers.com/lover/florc">florc</a> from <a href="http://www.colourlovers.com/lover/florc">colurlovers</a></p> 
	</footer>
	
</body> 
</html> 
