
package acme.features.administrator.chart;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("select count(h), h.sector from CompanyRecord h group by h.sector")
	Object[] companiesBySector();

	@Query("select count(h), h.sector from InvestorRecord h group by h.sector")
	Object[] investorsBySector();

	@Query("select 1.0*count(h)/(select count(*) from Job), h.status from Job h group by h.status")
	Object[] jobsByStatusRatio();

	@Query("select 1.0*count(h)/(select count(*) from Application), h.status from Application h group by h.status")
	Object[] applicationsByStatusRatio();

	@Query("select DATE(a.moment), a.status, count(a) from Application a where a.moment >= ?1 group by DAY(a.moment), a.status")
	Object[] findApplicationsLastMonthByDayAndStatus(Date date);
}
