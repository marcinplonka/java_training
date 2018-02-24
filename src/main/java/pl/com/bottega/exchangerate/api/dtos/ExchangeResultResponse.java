package pl.com.bottega.exchangerate.api.dtos;

import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

public class ExchangeResultResponse {
    private String from, to;
    private BigDecimal amount;
    private BigDecimal calculatedAmount;
    private LocalDate date;


    public ExchangeResultResponse(ExchangeCurrencyCommand cmd, BigDecimal calculatedAmount) {
        this.from = cmd.getFrom();
        this.to = cmd.getTo();
        this.amount = cmd.getAmount();
        this.calculatedAmount = calculatedAmount;
        this.date = cmd.getDate();
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
