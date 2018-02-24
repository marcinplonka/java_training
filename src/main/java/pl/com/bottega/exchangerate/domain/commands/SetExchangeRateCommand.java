package pl.com.bottega.exchangerate.domain.commands;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

public class SetExchangeRateCommand implements Validatable, Command {

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    private String currency;
    private BigDecimal rate;

    @Override
    public void validate(ValidationErrors errors) {
        validateCurrency(errors, "currency", currency);
        validateNegativity(errors, "rate", rate);
        validatePresence(errors, "date", date);
    }

    public SetExchangeRateCommand(LocalDate date, String currency, BigDecimal rate) {
        this.date = date;
        this.currency = currency;
        this.rate = rate;
    }

    public SetExchangeRateCommand() {
    }

    public LocalDate getExchangeRateDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }


}
