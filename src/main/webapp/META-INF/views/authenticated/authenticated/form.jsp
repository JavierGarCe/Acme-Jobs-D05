<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.authenticated.form.label.username" path="userAccount.username" />
	<acme:form-hidden path="threadId"/>

	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/authenticated/list-non-included?id=${id}');
	redirect('/authenticated/user-thread/create')" class="btn btn-primary">
	<acme:message code="authenticated.authenticated.form.button.includeInThread"/>
	</button>

	<acme:form-return code="authenticated.threads.form.button.return" />
</acme:form>