package pl.com.bottega.exchangerate.infrastructure;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRatePK;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
public class JPAExchangeRateRepository implements ExchangeRateRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public ExchangeRate get(ExchangeRatePK exchangeRatePK) {
        return entityManager.find(ExchangeRate.class, exchangeRatePK);
    }

    @Override
    @Transactional
    public void save(ExchangeRate exchangeRate) {
        entityManager.persist(exchangeRate);
    }
}
