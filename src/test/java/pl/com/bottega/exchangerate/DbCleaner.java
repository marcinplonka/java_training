package pl.com.bottega.exchangerate;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class DbCleaner {

	private static final String TRUNCATE_SCHEMA_QUERY = "DROP TABLE IF EXISTS exchange_rate";

	@PersistenceContext
	private EntityManager entityManager;
//
//	@Transactional
//	public void clean() {
//		entityManager.createNativeQuery(TRUNCATE_SCHEMA_QUERY).executeUpdate();
//	}

}
