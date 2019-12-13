<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.threads.form.label.title" path="title" />
	<jstl:if test="${command == 'show' }">
	<acme:form-moment code="authenticated.threads.form.label.moment" path="moment" />
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/message/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.threads.form.label.message"/>
	</button>
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/authenticated/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.threads.form.label.users"/>
	</button>
	</jstl:if>
	<acme:form-submit test="${command == 'create' }" code="authenticated.threads.button.create" action="/authenticated/thread/create" />				
	<acme:form-return code="authenticated.threads.form.button.return" />
</acme:form>