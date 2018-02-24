package pl.com.bottega.exchangerate.domain;
import pl.com.bottega.exchangerate.domain.commands.SetExchangeRateCommand;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate implements Serializable {
    @Id
    @EmbeddedId
    private ExchangeRatePK exRatePK;
    private BigDecimal rate;

    public ExchangeRate() {
    }

    public ExchangeRate(SetExchangeRateCommand command) {
        this.exRatePK = new ExchangeRatePK(command.getCurrency(), Date.valueOf(command.getExchangeRateDate()));
        this.rate = command.getRate();
    }

    public ExchangeRatePK getExRatePK() {
        return exRatePK;
    }

    public void setExRatePK(ExchangeRatePK exRatePK) {
        this.exRatePK = exRatePK;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
