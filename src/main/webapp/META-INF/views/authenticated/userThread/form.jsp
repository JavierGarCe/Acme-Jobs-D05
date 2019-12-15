<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.userThread.form.label.username" path="authenticated.userAccount.username" />
	<input type="hidden" name="threadId" id="threadId" value="${param.id}"/>
		
	<acme:form-submit code="authenticated.userThread.button.delete" action="/authenticated/user-thread/delete"/>

	<acme:form-return code="authenticated.threads.form.button.return" />
</acme:form>