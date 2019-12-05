
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.message.list.label.title" path="title" />
	<acme:list-column code="authenticated.message.list.label.body" path="body" />
	<acme:list-column code="authenticated.message.list.label.tags" path="tags" />
</acme:list>

<acme:form-return code="authenticated.message.form.button.return"/>