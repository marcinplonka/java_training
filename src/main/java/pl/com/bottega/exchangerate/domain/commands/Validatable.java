package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public interface Validatable {
    String THREE_UPPERCASE_LETTERS_REGEX = "^[A-Z]{3}$";


    void validate(ValidationErrors errors);

    class ValidationErrors {


        private Map<String, Set<String>> errors = new HashMap<>();

        public void add(String fieldName, String errorMessage) {
            Set<String> fieldErrors = errors.getOrDefault(fieldName, new HashSet<>());
            fieldErrors.add(errorMessage);
            errors.putIfAbsent(fieldName, fieldErrors);
        }

        public boolean isValid() {
            return errors.isEmpty();
        }

        public Map<String, Set<String>> getErrors() {
            return new HashMap<>(errors);
        }

        public boolean any() {
            return !errors.isEmpty();
        }
    }

    default boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    default void validateCurrency(ValidationErrors errors, String field, String currency) {
        if (currency == null) {
            errors.add(field, "can't be blank");
        } else {
            if (!Pattern.compile(THREE_UPPERCASE_LETTERS_REGEX).matcher(currency).matches()) {
                errors.add(field, "has invalid format");
            }
        }
    }

    default void validateNotEqualCurrencies(ValidationErrors errors, String fromField, String from, String toField, String to) {
        if(from.equals(to)) {
            errors.add(fromField, "must be different than to");
            errors.add(toField, "must be different than from");
        }
    }

    default void validateNegativity(ValidationErrors errors, String field, BigDecimal rate) {
        if (rate.compareTo(BigDecimal.ZERO) <= 0) {
            errors.add(field, "must be > than 0.0");
        }
    }

    default void validatePresence(ValidationErrors errors, String field, Object value) {
        if (value == null) {
            errors.add(field, "can't be blank");
        }
    }
}