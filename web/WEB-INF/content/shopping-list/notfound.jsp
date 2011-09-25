<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html> 
	<html> 
	<head> 
		<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
		<title>Shopping list - ${list.name}</title> 
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flick/jquery-ui.css" type="text/css" /> 
	</head> 
	<body> 
	<h1>Shopping list</h1>
	
	<h2>Not found</h2>
	
	<aside class="box error">
		Shopping list  was not found. You can return to <s:a action="shopping-list">main menu</s:a> and create new one.
	</aside>
	
	<footer>
			<p>&copy; by <a href="http://darekzon.com">darek zon</a></p>
			<p><a href="http://www.colourlovers.com/pattern/50713/pat">pattern</a> by <a href="http://www.colourlovers.com/lover/florc">florc</a> from <a href="http://www.colourlovers.com/lover/florc">colurlovers</a></p> 
	</footer>
	
</body> 
</html> 