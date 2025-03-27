package RosanaCeline.exception;

import java.util.Date;

// Record - classe que vai somente armazenar valores, sem mudar valores depois
public record ExceptionResponse(Date timestamp, String message, String details) {
}
