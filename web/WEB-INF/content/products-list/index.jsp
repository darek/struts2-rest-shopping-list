<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Lista produktów</h2>

<s:if test="%{productsList.size()>0}">
	<ul>
	<s:iterator id="product" value="productsList">
		<li><s:property value="name" /> <a href="/delete/<s:property value="id.html" />">x</a></li>
	</s:iterator>
	<li><s:form action="/add.html"><s:textfield name="productName" /></s:form></li>
	</ul>
</s:if>
