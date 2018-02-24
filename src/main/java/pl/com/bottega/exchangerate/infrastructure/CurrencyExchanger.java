package pl.com.bottega.exchangerate.infrastructure;

import pl.com.bottega.exchangerate.api.dtos.ExchangeResultResponse;
import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;

public interface CurrencyExchanger {
    String MAIN_CURRENCY = "PLN";

    ExchangeResultResponse calculate(ExchangeCurrencyCommand cmd);
}
