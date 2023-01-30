package cat.tecnocampus.tinder.likes.adapter.in.web.exceptionAdvice;

import cat.tecnocampus.tinder.likes.application.service.exception.LikeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdviceLike {

    @ResponseBody
    @ExceptionHandler(LikeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }


}
