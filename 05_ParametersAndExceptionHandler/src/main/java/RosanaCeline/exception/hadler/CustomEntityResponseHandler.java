package RosanaCeline.exception.hadler;

import RosanaCeline.exception.ExceptionResponse;
import RosanaCeline.exception.NegativeNumberException;
import RosanaCeline.exception.UnsuportedMathOperationException;
import RosanaCeline.exception.DivisionByZeroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// Indica que essa classe trata excecoes globalmente, para toda a aplicacao Spring Boot
@ControllerAdvice

// Define que a classe eh um controlador REST
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    // Trata todas as excecoes genericas da aplicacao
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {

        // Cria um objeto de resposta personalizada, com:
        // data e hora do erro
        // mensagem da excecao
        // descricao da requisicao onde ocorreu o erro
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        // Retorna a resposta personalizada com status HTTP 500 (Internal Server Error)
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Trata especificamente a excecao UnsuportedMathOperationException e DivisionByZeroException
    // como uma array de excecoes
    @ExceptionHandler({UnsuportedMathOperationException.class, DivisionByZeroException.class, NegativeNumberException.class})
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {

        // Cria um objeto de resposta personalizada para erros do tipo BAD_REQUEST
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        // Retorna a resposta personalizada com status HTTP 400 (Bad Request)
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
