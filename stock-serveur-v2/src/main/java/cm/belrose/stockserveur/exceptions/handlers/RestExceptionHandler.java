package cm.belrose.stockserveur.exceptions.handlers;

import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

/**
 * @author Ngnawen
 *
 * Cette classe represente le gestion global des exceptions.
 * Elle capture toute exception renvoyée, de n'importe ou dans l'application dans l'application.
 * Dans notre cas actuellement, nous intesecterons deux types d'exception:  EntityNotFoundException et
 * InvalidEntityException
 */

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Cette méthode s'occupe des exceptions du type EntityNotFoundException
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerException(EntityNotFoundException exception, WebRequest webRequest){
        final  HttpStatus notFound=HttpStatus.NOT_FOUND;
        ErrorDto errorDto=ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
         return new ResponseEntity<>(errorDto,notFound);
    }

    /**
     * Cette méthode s'occupe des exceptions du type InvalidEntityException
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handlerException(InvalidEntityException exception, WebRequest webRequest){
        final  HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        ErrorDto errorDto=ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto,badRequest);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDto> handlerException(BadCredentialsException exception, WebRequest webRequest){
        final  HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        ErrorDto errorDto=ErrorDto.builder()
                .code(ErrorCodes.BAD_CREDENTIALS)
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(Collections.singletonList("Login et/ou Password incorrect"))
                .build();
        return new ResponseEntity<>(errorDto,badRequest);
    }
}
