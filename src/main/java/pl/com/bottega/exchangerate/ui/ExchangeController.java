package pl.com.bottega.exchangerate.ui;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.exchangerate.api.CommandGateway;
import pl.com.bottega.exchangerate.api.dtos.ExchangeResultResponse;
import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;
import pl.com.bottega.exchangerate.domain.commands.SetExchangeRateCommand;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

@RestController
public class ExchangeController {

    private CommandGateway gateway;

    public ExchangeController(CommandGateway gateway) {
        this.gateway = gateway;
    }

    @GetMapping("/calculation")
    public ExchangeResultResponse calculate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                            @RequestParam String from,
                                            @RequestParam String to,
                                            @RequestParam BigDecimal amount){
        ExchangeCurrencyCommand command = new ExchangeCurrencyCommand(from, to, amount, date);
        return gateway.execute(command);
    }

    @PutMapping("/exchange-rate")
    public void create(@RequestBody SetExchangeRateCommand command){
        gateway.execute(command);
    }
}