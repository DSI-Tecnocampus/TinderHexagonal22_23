package cat.tecnocampus.tinder.profiles.adapter.in.web;

import cat.tecnocampus.tinder.profiles.application.port.in.CreateProfile;
import cat.tecnocampus.tinder.profiles.application.port.in.CreateProfileCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StoreProfileController {
    private final CreateProfile createProfile;

    public StoreProfileController(CreateProfile createProfile) {
        this.createProfile = createProfile;
    }

    @PostMapping("/profiles")
    public void storeProfile(@RequestBody CreateProfileCommand createProfileCommand) {
        createProfile.createProfile(createProfileCommand);
    }
}
