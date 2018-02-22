package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigInteger;
import java.time.LocalDate;

public class CalculationCommand implements Validatable {
    private String from;
    private String to;
    private BigInteger amount;
    private LocalDate date;

    public CalculationCommand(String from, String to, BigInteger amount, LocalDate date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateCurrency(errors, "from", from);
        validateCurrency(errors, "to", to);
        validateNegativity(errors, "amount", amount);
        validatePresence(errors, "date", date);
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
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
