package cat.tecnocampus.tinder.profiles.application.service;

import cat.tecnocampus.tinder.profiles.application.port.in.CreateProfile;
import cat.tecnocampus.tinder.profiles.application.port.in.CreateProfileCommand;
import cat.tecnocampus.tinder.profiles.application.port.out.ListProfilePort;
import cat.tecnocampus.tinder.profiles.application.port.out.StoreProfilePort;
import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileAlreadyExists;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
class CreateProfileService implements CreateProfile {
    private final ListProfilePort listProfilePort;
    private final StoreProfilePort storeProfilePort;

    public CreateProfileService(ListProfilePort listProfilePort, StoreProfilePort storeProfilePort) {
        this.listProfilePort = listProfilePort;
        this.storeProfilePort = storeProfilePort;
    }

    @Override
    public void createProfile(CreateProfileCommand createProfileCommand) {
        listProfilePort.loadProfileByEmail(createProfileCommand.email()).
                ifPresent(p -> {
                    throw new ProfileAlreadyExists(createProfileCommand.email());
                });

        storeProfilePort.storeProfile(createProfileCommand);
    }
}
