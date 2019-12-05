<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.threads.form.label.title" path="title" />
	<acme:form-moment code="authenticated.threads.form.label.moment" path="moment"/>
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/message/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.threads.form.label.message"/>
	</button>				
	<acme:form-return code="authenticated.threads.form.button.return" />
</acme:form>