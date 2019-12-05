
package acme.features.worker.auditRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class WorkerAuditRecordListMineService implements AbstractListService<Worker, AuditRecord> {

	@Autowired
	WorkerAuditRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditRecord> request) {
		assert request != null;
		int JobId = request.getModel().getInteger("id");
		Principal principal = request.getPrincipal();
		return this.repository.findNumberApplicationsByJobId(JobId, principal.getActiveRoleId()) > 0; //el worker debe haber hecho al menos una application al trabajo en cuestion para poder ver sus audit records
	}

	@Override
	public void unbind(final Request<AuditRecord> request, final AuditRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "status");
	}

	@Override
	public Collection<AuditRecord> findMany(final Request<AuditRecord> request) {

		assert request != null;
		int jobId;
		Collection<AuditRecord> result;
		jobId = request.getModel().getInteger("id");
		result = this.repository.findManyByJobId(jobId);

		return result;
	}

}
