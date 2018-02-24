package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.exchangerate.api.dtos.ExchangeResultResponse;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRatePK;
import pl.com.bottega.exchangerate.domain.NoRateException;
import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Optional;

@Component
public class JPACurrencyExchanger implements CurrencyExchanger {

    private ExchangeRateRepository exchangeRateRepository;

    public JPACurrencyExchanger(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public ExchangeResultResponse calculate(ExchangeCurrencyCommand cmd) {
        validateRatePresence(cmd);
        this.getCalculatedAmount(cmd);
        return new ExchangeResultResponse(cmd, this.getCalculatedAmount(cmd));
    }

    private void validateRatePresence(ExchangeCurrencyCommand cmd) {
        Optional<ExchangeRate> from;
        Optional<ExchangeRate> to;

        from = exchangeRateRepository.get(new ExchangeRatePK(cmd.getFrom(), Date.valueOf(cmd.getDate())));
        to = exchangeRateRepository.get(new ExchangeRatePK(cmd.getTo(), Date.valueOf(cmd.getDate())));
        if ((!from.isPresent() && !cmd.getFrom().equals(MAIN_CURRENCY))
                || (!to.isPresent() && !cmd.getTo().equals(MAIN_CURRENCY))) {
            throw new NoRateException("no exchange rate defined");
        }
    }

    private BigDecimal getCalculatedAmount(ExchangeCurrencyCommand cmd) {
        if (cmd.getFrom().equals(MAIN_CURRENCY))
            return cmd.getAmount().divide(this.getRate(new ExchangeRatePK(cmd.getTo(),
                    Date.valueOf(cmd.getDate()))), 2);
        if(cmd.getTo().equals(MAIN_CURRENCY)) {
            return cmd.getAmount().multiply(this.getRate(new ExchangeRatePK(cmd.getFrom(),
                    Date.valueOf(cmd.getDate()))));
        } else {
            return (cmd.getAmount().multiply(this.getRate(new ExchangeRatePK(cmd.getFrom(), Date.valueOf(cmd.getDate()))))
                    .divide(this.getRate(new ExchangeRatePK(cmd.getTo(), Date.valueOf(cmd.getDate()))), 2));
        }

    }

    private BigDecimal getRate(ExchangeRatePK exchangeRatePK) {
        return exchangeRateRepository.get(exchangeRatePK).orElseGet(ExchangeRate::new).getRate();
    }
}



