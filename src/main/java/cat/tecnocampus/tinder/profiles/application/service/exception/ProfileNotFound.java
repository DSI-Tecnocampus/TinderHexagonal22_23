package cat.tecnocampus.tinder.profiles.application.service.exception;

public class ProfileNotFound extends RuntimeException{
    public ProfileNotFound(String email)  {
        super("User " + email + " does not exist");
    }
}
