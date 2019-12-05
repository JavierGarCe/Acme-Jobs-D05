
package acme.features.auditor.AuditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select b from AuditRecord b where b.id = ?1")
	AuditRecord findOneAuditRecordById(int id);

	@Query("select b from AuditRecord b where b.job.id = ?1")
	Collection<AuditRecord> findManyByJobId(int jobId);

	@Query("select b from AuditRecord b where b.job.id = ?1 and (b.auditor.id = ?2 or b.status != 'DRAFT')")
	Collection<AuditRecord> findManyByJobIdActives(int jobId, int auditorId);

	@Query("select b from AuditRecord b")
	Collection<AuditRecord> findMany();

}
