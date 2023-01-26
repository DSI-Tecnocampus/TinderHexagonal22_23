package cat.tecnocampus.tinder.profiles.application.port.in;

import java.util.List;

public interface ListProfiles {
    List<ProfileListing> getAllProfiles();

    ProfileListing getProfileByNickname(String nickname);

    ProfileListing getProfileByEmail(String email);
}
