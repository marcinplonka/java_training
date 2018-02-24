package pl.com.bottega.exchangerate.infrastructure;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.InvalidCommandException;
import pl.com.bottega.exchangerate.domain.commands.Validatable;

@Component
@Aspect
public class ValidationAspect {

	@Before( "execution(* pl.com.bottega.exchangerate.api..*.*(..)) && args(command,..)" )
	public void validate(Command command) {
		Validatable.ValidationErrors errors = new Validatable.ValidationErrors();
		command.validate(errors);
		if (!errors.isValid())
			throw new InvalidCommandException(errors);
	}

}
