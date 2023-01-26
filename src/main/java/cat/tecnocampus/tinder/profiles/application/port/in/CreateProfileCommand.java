package cat.tecnocampus.tinder.profiles.application.port.in;

import cat.tecnocampus.tinder.profiles.domain.Profile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record CreateProfileCommand(
       @NotNull (message = "Email can't be null")
       @Email(message = "Must look like an email")
       String email,
       @NotNull
       @Size(min=4, max=255, message="nickname must be 4-255 characters long")
       String nickname,
       Profile.Gender gender,
       Profile.Gender attraction,
       Profile.Passion passion) {
}
