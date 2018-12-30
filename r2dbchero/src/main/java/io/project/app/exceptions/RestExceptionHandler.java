package io.project.app.exceptions;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 *
 * @author armdev
 */
@Component
@Order(-2)
@Slf4j
public class RestExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (ex instanceof BadRequestException) {
             log.error("BAD_REQUEST");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            // marks the response as complete and forbids writing to it
            return exchange.getResponse().setComplete();
        } else if (ex instanceof NotFoundException) {
            log.error("Not Found exception!!!!");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            // marks the response as complete and forbids writing to it
            return exchange.getResponse().setComplete();
        } else {
            log.error("EXPECTATION_FAILED");
            exchange.getResponse().setStatusCode(HttpStatus.EXPECTATION_FAILED);
            // marks the response as complete and forbids writing to it
            return exchange.getResponse().setComplete();
        }
        //return Mono.error(ex);
    }
    
    
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(new Date(System.currentTimeMillis()), "DuplicateKeyException", "DuplicateKeyException Hmmm."));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleTweetNotFoundException(NotFoundException ex) {
        log.error("handleTweetNotFoundException");
        return ResponseEntity.notFound().build();
    }


}
