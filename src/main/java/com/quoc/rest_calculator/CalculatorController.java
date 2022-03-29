package com.quoc.rest_calculator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CalculatorController {

    @GetMapping("/calculator")
    public OperationResult calculate(
            @RequestParam(value = "input1") String input1,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "input2") String input2
    ) {
        String sResult;
       try {
           double result = CalculatorService.performOperation(input1, operation, input2);
           sResult = String.valueOf(result);
       } catch (Error e) {
           sResult = e.getMessage();
       }

       return new OperationResult(sResult);
    }
}
