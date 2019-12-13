
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.authenticated.list.label.username" path="userAccount.username" />	
</acme:list>

	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/authenticated/list-mine?threadId=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.threads.form.label.users"/>
	</button>