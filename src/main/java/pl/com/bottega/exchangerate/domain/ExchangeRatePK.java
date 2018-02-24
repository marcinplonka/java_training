package pl.com.bottega.exchangerate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class ExchangeRatePK implements Serializable {
    private String currency;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;

    public ExchangeRatePK() {}

    public ExchangeRatePK(String currency, Date date) {
        this.currency = currency;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRatePK that = (ExchangeRatePK) o;
        return Objects.equals(currency, that.currency) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(currency, date);
    }
}
