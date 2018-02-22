package pl.com.bottega.exchangerate.ui;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.exchangerate.api.CommandGateway;
import pl.com.bottega.exchangerate.api.dtos.CalculationResponseDto;
import pl.com.bottega.exchangerate.domain.commands.CalculationCommand;
import pl.com.bottega.exchangerate.domain.commands.SetExchangeRateCommand;

import java.math.BigInteger;
import java.time.LocalDate;

@RestController
public class ExchangeController {

    private CommandGateway gateway;



    @GetMapping("/calculation")
    public CalculationResponseDto calculate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                            @RequestParam String from,
                                            @RequestParam String to,
                                            @RequestParam BigInteger amount){
        CalculationCommand command = new CalculationCommand(from, to, amount, date);
        return gateway.execute(command);
    }

    @PutMapping("/exchange-rate")
    public void create(@RequestBody SetExchangeRateCommand command){
        gateway.execute(command);
    }
}