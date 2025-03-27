package RosanaCeline.controllers;

import RosanaCeline.math.Operations;
import RosanaCeline.validation.NumberConvertion;
import RosanaCeline.validation.NumberVerification;
import RosanaCeline.exception.DivisionByZeroException;
import RosanaCeline.exception.NegativeNumberException;
import RosanaCeline.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Indica que a classe eh um controlador Rest, que processa requisicoes HTTP e retorna JSON
@RestController

// Define que todos os endpoints da classe vai ter o prefixo /math na URL
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    // Define que o metodo respondera a requisicoes nesse formato
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            // Captura os valores da URL como String
            // Foram definidos em String para fazer as excecoes
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception{
        if(!NumberVerification.isNumeric(numberOne) || !NumberVerification.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return Operations.sum(NumberConvertion.convertToDouble(numberOne), NumberConvertion.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberVerification.isNumeric(numberOne) || !NumberVerification.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return Operations.subtraction(NumberConvertion.convertToDouble(numberOne), NumberConvertion.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberVerification.isNumeric(numberOne) || !NumberVerification.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return Operations.multiplication(NumberConvertion.convertToDouble(numberOne), NumberConvertion.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberVerification.isNumeric(numberOne) || !NumberVerification.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        if(NumberConvertion.convertToDouble(numberTwo) == 0) throw new DivisionByZeroException("Number two cant be 0!");
        return Operations.division(NumberConvertion.convertToDouble(numberOne), NumberConvertion.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberVerification.isNumeric(numberOne) || !NumberVerification.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return Operations.mean(NumberConvertion.convertToDouble(numberOne), NumberConvertion.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/squareRoot/3/5
    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    ) throws Exception {
        if(!NumberVerification.isNumeric(number)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        if(NumberConvertion.convertToDouble(number) < 0) throw new NegativeNumberException("Number two cant be negative!");
        return Operations.squareRoot(NumberConvertion.convertToDouble(number));
    }
}
