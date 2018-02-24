package pl.com.bottega.exchangerate.domain.repositories;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRatePK;

import java.util.Optional;

public interface ExchangeRateRepository {

    Optional<ExchangeRate> get(ExchangeRatePK exchangeRatePK);

    void save(ExchangeRate exchangeRate);

}
