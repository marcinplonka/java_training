package pl.com.bottega.exchangerate.api.dtos;

import java.math.BigInteger;
import java.time.LocalDate;

public class CalculationResponseDto {
    private String from, to;
    private Double amount;
    private BigInteger calculatedAmount;
    private LocalDate date;


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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BigInteger getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigInteger calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
