package cat.tecnocampus.tinder.profiles.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface CreateProfile {
    void createProfile(@Valid CreateProfileCommand createProfileCommand);
}
