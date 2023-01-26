package cat.tecnocampus.tinder.profiles.application.port.in;

import java.util.List;

public interface ListProfileCandidates {
    List<ProfileListing> getProfileCandidates(String email);
}
