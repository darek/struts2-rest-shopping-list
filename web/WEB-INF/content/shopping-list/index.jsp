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
	
	<aside class="panel left">
		<h2>Open shopping list</h2>
		<form id="open-shopping-list">
			<input id="code" name="list.id" placeholder="Shopping List ID" />
			<input type="submit" value="go" name="" />
		</form>
	</aside>
	
	<aside class="panel right">
		<h2>Add shopping list</h2>
		<form id="add-shopping-list" method="post" action="${pageContext.request.contextPath}/shopping-list.xhtml">
			<input type="text" placeholder="Shopping list name" id="name" name="list.name" />
			<input type="submit" value="go" />
		</form>
	</aside>
</body> 
</html> 
