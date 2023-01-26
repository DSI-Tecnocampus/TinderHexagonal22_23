package cat.tecnocampus.tinder.profiles.application.port.out;

import cat.tecnocampus.tinder.profiles.application.port.in.CreateProfileCommand;

public interface StoreProfilePort {
    public void storeProfile(CreateProfileCommand createProfileCommand);
}
