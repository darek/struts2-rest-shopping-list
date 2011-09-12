<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html> 
<html>
	<head>
		
	</head>
	<body>
	
	<article>
		<h2>Open shopping list</h2>
		<form id="open-shopping-list">
			<input id="code" name="list.id" placeholder="Shopping List ID" />
			<input type="submit" value="go" name="" />
		</form>
	</article>
	
	<s:if test="%{#list!=null && #list.id!=null}">
	Shopping list added. ID: %{list.id}, You can go and <a href="${pageContext.request.contextPath}/shopping-list/%{list.id}.xhtml">see it</a>.
	</s:if>
	
	<s:if test="%{#list==null">
	dupa
	</s:if>
	
	<article>
		<h2>Add shopping list</h2>
		<form id="add-shopping-list" method="post" action="${pageContext.request.contextPath}/shopping-list.xhtml">
			<input type="text" placeholder="Shopping list name" id="name" name="list.name" />
			<input type="submit" value="go" />
		</form>
	</article>
	
	
	
	</body>
</html>