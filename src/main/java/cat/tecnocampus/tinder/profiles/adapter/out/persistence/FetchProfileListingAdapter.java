package cat.tecnocampus.tinder.profiles.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import cat.tecnocampus.tinder.profiles.application.port.out.ListProfilePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FetchProfileListingAdapter implements ListProfilePort {
    ProfileRepository profileRepository;

    public FetchProfileListingAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<ProfileListing> loadProfileByEmail(String email) {
        return profileRepository.getByEmail(email);
    }

    @Override
    public Optional<ProfileListing> loadProfileByNickname(String nickname) {
        return profileRepository.getByNickname(nickname);
    }

    @Override
    public List<ProfileListing> loadAllProfiles() {
        return profileRepository.findAllListing();
    }
}
