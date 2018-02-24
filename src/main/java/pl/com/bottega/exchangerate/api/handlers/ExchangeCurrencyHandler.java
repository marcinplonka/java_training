package pl.com.bottega.exchangerate.api.handlers;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.api.dtos.ExchangeResultResponse;
import pl.com.bottega.exchangerate.domain.commands.*;
import pl.com.bottega.exchangerate.infrastructure.CurrencyExchanger;

@Component
public class ExchangeCurrencyHandler implements Handler<ExchangeCurrencyCommand, ExchangeResultResponse> {


    private CurrencyExchanger currencyExchanger;

    public ExchangeCurrencyHandler(CurrencyExchanger currencyExchanger) {
        this.currencyExchanger = currencyExchanger;
    }

    @Override
    public ExchangeResultResponse handle(ExchangeCurrencyCommand command) {
        return currencyExchanger.calculate(command);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return ExchangeCurrencyCommand.class;
    }
}
