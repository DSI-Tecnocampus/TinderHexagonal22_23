package cat.tecnocampus.tinder.profiles.adapter.in.web.exceptionAdvice;

import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileAlreadyExists;
import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdviceProfile {

    @ResponseBody
    @ExceptionHandler(ProfileNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProfileAlreadyExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String profileAlreadyExists(Exception ex) {
        return ex.getMessage();
    }

}
