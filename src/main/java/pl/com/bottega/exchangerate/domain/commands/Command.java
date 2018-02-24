package pl.com.bottega.exchangerate.domain.commands;

public interface Command {
    void validate(Validatable.ValidationErrors errors);
}
