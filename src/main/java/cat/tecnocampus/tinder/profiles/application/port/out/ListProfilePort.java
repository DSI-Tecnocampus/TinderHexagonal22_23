package cat.tecnocampus.tinder.profiles.application.port.out;

import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;

import java.util.List;
import java.util.Optional;

public interface ListProfilePort {

    Optional<ProfileListing> loadProfileByEmail(String email);

    Optional<ProfileListing> loadProfileByNickname(String nickname);

    List<ProfileListing> loadAllProfiles();
}
