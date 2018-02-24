package pl.com.bottega.exchangerate.domain.commands;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

public class ExchangeCurrencyCommand implements Validatable, Command {
    private String from;
    private String to;
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    public ExchangeCurrencyCommand(String from, String to, BigDecimal amount, LocalDate date) {

        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateCurrency(errors, "from", from);
        validateCurrency(errors, "to", to);
        validateNotEqualCurrencies(errors, "from",from, "to", to);
        validateNegativity(errors, "amount", amount);
        validatePresence(errors, "date", date);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
