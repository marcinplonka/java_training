package pl.com.bottega.exchangerate.api.handlers;

import org.springframework.stereotype.Component;
import pl.com.bottega.exchangerate.domain.commands.InvalidCommandException;
import pl.com.bottega.exchangerate.domain.commands.SetExchangeRateCommand;
import pl.com.bottega.exchangerate.domain.commands.Validatable;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

@Component
public class SetExchangeRateHandler implements Handler<SetExchangeRateCommand, Void> {

    private ExchangeRateRepository exchangeRateRepository;

    public SetExchangeRateHandler(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public Void handle(SetExchangeRateCommand command) {
            throw new InvalidCommandException(new Validatable.ValidationErrors());

        //TODO
    }

    @Override
    public Class<? extends Validatable> getSupportedCommandClass() {
        return SetExchangeRateCommand.class;
    }
}
