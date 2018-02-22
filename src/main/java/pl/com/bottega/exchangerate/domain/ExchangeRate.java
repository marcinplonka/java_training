package pl.com.bottega.exchangerate.domain;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
public class ExchangeRate implements Serializable {
    @EmbeddedId
    private ExchangeRatePK exRatePK;
    private BigInteger rate;

    public ExchangeRate() {
    }
}
