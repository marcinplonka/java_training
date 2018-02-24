package pl.com.bottega.exchangerate.infrastructure;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRatePK;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


@Component
public class JPAExchangeRateRepository implements ExchangeRateRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public  Optional<ExchangeRate> get(ExchangeRatePK exchangeRatePK) {
        return Optional.ofNullable(entityManager.find(ExchangeRate.class, exchangeRatePK));
    }

    @Override
    @Transactional
    public void save(ExchangeRate exchangeRate) {
        entityManager.merge(exchangeRate);
    }
}
