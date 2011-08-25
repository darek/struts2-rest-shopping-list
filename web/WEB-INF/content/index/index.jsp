<%@ taglib prefix="s" uri="/struts-tags"  %>

<s:form method="get" action="products-list">
	<s:label for="email">Email
	<s:textfield id="email" name="email" /></s:label>
	<s:label for="code">Code:
	<s:textfield id="code" name="code" /></s:label>
	<s:submit value="pokaz liste" />
</s:form>


<s:form method="post" action="index">
	<s:label for="c-email">Email:
	<s:textfield id="c-email" name="email" /></s:label>
	<s:submit value="stworz liste" />
</s:form>