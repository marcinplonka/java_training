package pl.com.bottega.exchangerate.domain;


public class NoRateException extends RuntimeException {
    public NoRateException(String message) {
        super(message);
    }
}
