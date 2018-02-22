package pl.com.bottega.exchangerate.domain.repositories;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRatePK;

public interface ExchangeRateRepository {

    ExchangeRate get(ExchangeRatePK exchangeRatePK);

    void save(ExchangeRate exchangeRate);

}
