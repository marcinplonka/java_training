package pl.com.bottega.exchangerate.api.handlers;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.Command;
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
    @Transactional
    public Void handle(SetExchangeRateCommand command) {

        exchangeRateRepository.save(new ExchangeRate(command));
        return null;
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return SetExchangeRateCommand.class;
    }
}
