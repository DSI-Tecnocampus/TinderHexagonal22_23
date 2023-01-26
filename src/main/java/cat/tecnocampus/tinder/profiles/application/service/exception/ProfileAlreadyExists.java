package cat.tecnocampus.tinder.profiles.application.service.exception;

public class ProfileAlreadyExists extends RuntimeException{
    public ProfileAlreadyExists(String email)  {
        super("User " + email + " already exists");
    }
}
