package cat.tecnocampus.tinder.profiles.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.application.port.in.CreateProfileCommand;
import cat.tecnocampus.tinder.profiles.application.port.out.StoreProfilePort;
import org.springframework.stereotype.Component;

@Component
public class StoreProfileAdapter implements StoreProfilePort {
    private final ProfileRepository profileRepository;

    public StoreProfileAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void storeProfile(CreateProfileCommand createProfileCommand) {
        profileRepository.save(profileCommand2ProfileEntity(createProfileCommand));

        //TODO add a user_lab (security)
    }

    private ProfileEntity profileCommand2ProfileEntity(CreateProfileCommand createProfileCommand) {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEmail(createProfileCommand.email());
        profileEntity.setNickname(createProfileCommand.nickname());
        profileEntity.setGender(createProfileCommand.gender());
        profileEntity.setAttraction(createProfileCommand.attraction());
        profileEntity.setPassion(createProfileCommand.passion());

        return profileEntity;
    }
}
