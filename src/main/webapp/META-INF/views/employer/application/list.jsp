<%--
- list.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="employer.application.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="employer.application.list.label.status" path="status" width="20%"/>
	<acme:list-column code="employer.application.list.label.statement" path="statement" width="40%"/>
		<acme:list-column code="employer.application.list.label.reference" path="reference" width="20%"/>
</acme:list>
	<button type="button" onclick="javascript: pushReturnUrl('/employer/application/list-mine'); redirect('/employer/application/list-by-moment')" class="btn btn-primary">
		<acme:message code="employer.application.list.button.creation" />
	</button>
	<button type="button" onclick="javascript: pushReturnUrl('/employer/application/list-mine'); redirect('/employer/application/list-by-reference')" class="btn btn-primary">
		<acme:message code="employer.application.list.button.reference" />
	</button>
	<button type="button" onclick="javascript: pushReturnUrl('/employer/application/list-mine'); redirect('/employer/application/list-by-status')" class="btn btn-primary">
		<acme:message code="employer.application.list.button.status" />
	</button>
