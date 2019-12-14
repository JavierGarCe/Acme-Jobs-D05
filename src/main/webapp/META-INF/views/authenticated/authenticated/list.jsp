

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="authenticated.authenticated.list.label.username" path="userAccount.username" />
</acme:list>
<acme:form readonly="false">
	<acme:form-select readonly="false" path="idAuthenticated" code="authenticated.authenticated.form.select">

		<jstl:forEach var= "var" begin="${0}" end = "${model$size-1}">
			<jstl:set var="var1" value="id[${var}]" />
			<jstl:set var="var2" value="userAccount.username[${var}]" />
			<acme:form-option code="${requestScope[var2]}" value="${requestScope[var1]}" />
		</jstl:forEach>
	
	
	      </acme:form-select>
	<!--  <button type="button" onclick="javascript: pushReturnUrl('/authenticated/authenticated/list-non-included?threadId=${param.threadId}');
	redirect('/authenticated/user-thread/create?threadId=${param.threadId}')" class="btn btn-primary">
	<acme:message code="authenticated.userThread.list.button.createIncludedUsers"/>
	</button>    -->  
	<acme:form-submit code="authenticated.userThread.list.button.createIncludedUsers" action="/authenticated/user-thread/create?threadId=${param.threadId}"/>
</acme:form>
	
<acme:form-return code="authenticated.authenticated.list.button.return"/>