package RosanaCeline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Indica que, sempre que essa excecao for lancada, o Spring deve retornar um codigo HTTP 400
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

  public UnsuportedMathOperationException(String message) {
      super(message);
    }
}
