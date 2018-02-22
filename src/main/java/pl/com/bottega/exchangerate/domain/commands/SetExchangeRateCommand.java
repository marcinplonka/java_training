package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigInteger;
import java.util.Date;

public class SetExchangeRateCommand implements Validatable {

    private Date        date;
    private String      currency;
    private BigInteger  rate;

    @Override
    public void validate(ValidationErrors errors) {
        validateCurrency(errors, "currency", currency);
        validateNegativity(errors, "rate", rate);
        validatePresence(errors, "date", date);
    }


    public Date getExchangeRateDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigInteger getRate() {
        return rate;
    }

    public void setRate(BigInteger rate) {
        this.rate = rate;
    }


}
