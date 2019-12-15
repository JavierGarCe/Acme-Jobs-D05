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

<acme:form readonly="${status == 'PUBLISHED' && command == 'show' }">
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
	<acme:form-textbox  code="employer.job.form.label.employer.name" path="employer.userAccount.username" readonly="true"/>
	</jstl:if>
	<acme:form-panel code="employer.job.form.label.descriptor">
		<acme:form-textarea code="employer.job.form.label.descriptor.description" path="descriptor.description" />
	</acme:form-panel>

<!--  	<acme:form-submit test="${command == 'show' }" code="master.menu.employer.listAuditRecords" action="/employer/auditRecord/list-mine?id=${param.id}" method="get"/>-->
<!-- <acme:form-submit test="${command == 'show'}" code="employer.job.form.label.descriptorMessage" action="/employer/duty/list?jobId=${id}" method="get" />-->
	<div class="collapse" id="alertUpdate">
 	 <div class="alert alert-danger">
 		<acme:message code="master.menu.employer.notUpdate"/>
	</div>
	</div>
	
	<div class="collapse" id="alertDelete">
 	 <div class="alert alert-danger">
 		<acme:message code="master.menu.employer.notDelete"/>
	</div>
	</div>
	
	<jstl:if test="${command == 'show' }">
 	<button type="button" onclick="javascript: pushReturnUrl('/employer/job/show?id=${id}'); redirect('/employer/auditRecord/list-mine?id=${param.id}')" class="btn btn-primary">
		<acme:message code="master.menu.employer.listAuditRecords" />
	</button> 
	
	<button  type="button" onclick="javascript: pushReturnUrl('/employer/job/show?id=${id}'); redirect('/employer/duty/list?jobId=${id}')" class="btn btn-primary">
		<acme:message code="employer.job.form.label.descriptorMessage" />
	</button>
	
	<jstl:if test="${status == 'DRAFT' }">
	<acme:form-submit code="employer.job.button.update" action="/employer/job/update"/>
	</jstl:if>

	<jstl:if test="${status == 'PUBLISHED' }">
 	<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#alertUpdate" aria-expanded="false" aria-controls="collapseExample">
  		<acme:message code="employer.job.button.update"/>
  	</button>
  	</jstl:if>
  	
  	<jstl:if test="${hasApplications == 'false' }">
	<acme:form-submit code="employer.job.button.delete" action="/employer/job/delete"/>
	</jstl:if>

	<jstl:if test="${hasApplications == 'true'}">
 	<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#alertDelete" aria-expanded="false" aria-controls="collapseExample">
  		<acme:message code="employer.job.button.delete"/>
  	</button>
	</jstl:if>
	
	</jstl:if>
	<acme:form-submit test="${command == 'create'}" code="employer.job.button.create" action="/employer/job/create" />
	<!--<acme:form-submit test="${command == 'show' && status == 'DRAFT'}" code="employer.job.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'show' && hasApplications == 'false'}" code="employer.job.button.delete" action="/employer/job/delete" />	
	-->
	<acme:form-submit test="${command == 'update'}" code="employer.job.button.update" action="/employer/job/update" />
	<acme:form-submit test="${command == 'delete'}" code="employer.job.button.delete" action="/employer/job/delete" />	
	<acme:form-return code="employer.job.form.button.return"/>
	

</acme:form>