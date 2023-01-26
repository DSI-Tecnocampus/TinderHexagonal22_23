package cat.tecnocampus.tinder.profiles.adapter.in.web.frontendException;

import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileAlreadyExists;
import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ResponseBody
    @ExceptionHandler(ProfileNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ProfileAlreadyExists.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String objectAlreadyExists(Exception exception) {
        return exception.getMessage();
    }

}
