<%--
- form.jsp
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

<acme:form>
	<acme:form-textbox code="employer.job.form.label.title" path="title" />
	<acme:form-textbox code="employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-select code="employer.job.form.label.status" path="status" >
		<jstl:choose>
			<jstl:when test="${status == 'PUBLISHED' }"> <jstl:set var="publishedSelected" value="true"/> </jstl:when>
			<jstl:otherwise><jstl:set var="publishedSelected" value="false"/></jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${status == 'DRAFT' }"> <jstl:set var="draftSelected" value="true"/> </jstl:when>
			<jstl:otherwise><jstl:set var="draftSelected" value="false"/></jstl:otherwise>
		</jstl:choose>
		<acme:form-option code="employer.job.form.label.status.published" value="PUBLISHED"  selected="${publishedSelected}" />
		<acme:form-option code="employer.job.form.label.status.draft" value="DRAFT" selected="${draftSelected}" />
	</acme:form-select>
	<acme:form-money code="employer.job.form.label.salary" path="salary" />
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline" />
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo" />
	<jstl:if test="${command == 'show' }">
	<acme:form-textbox  code="employer.job.form.label.employer.name" path="employer.userAccount.username" />
	</jstl:if>
	<acme:form-panel code="employer.job.form.label.descriptor">
		<acme:form-textarea code="employer.job.form.label.descriptor.description" path="descriptor.description" />
	</acme:form-panel>

	<!--  <button type="button" onclick="javascript: pushReturnUrl('/employer/job/show?id=${id}'); redirect('/employer/auditRecord/list-mine?id=${param.id}')" class="btn btn-primary">
		<acme:message code="master.menu.employer.listAuditRecords" />
	</button> -->
	
	<acme:form-submit test="${command == 'show' }" code="master.menu.employer.listAuditRecords" action="/employer/auditRecord/list-mine?id=${param.id}" method="get"/>

	<!-- <button  type="button" onclick="javascript: pushReturnUrl('/employer/job/show?id=${id}'); redirect('/employer/duty/list?id=${id}')" class="btn btn-primary">
		<acme:message code="employer.job.form.label.descriptorMessage" />
	</button>-->

	<acme:form-submit test="${command == 'show' }" code="employer.job.form.label.descriptorMessage" action="/employer/duty/list?id=${id}" method="get"/>
	<acme:form-submit test="${command == 'create' }" code="employer.job.button.create" action="/employer/job/create" />
	<acme:form-submit test="${command == 'show' }" code="employer.job.form.label.create.duty" action="/employer/duty/create?jobId=${id}" method="get"/>
	
		
	<acme:form-return code="employer.job.form.button.return"/>



</acme:form>