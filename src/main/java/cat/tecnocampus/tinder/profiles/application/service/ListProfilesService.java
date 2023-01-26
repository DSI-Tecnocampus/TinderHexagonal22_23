package cat.tecnocampus.tinder.profiles.application.service;

import cat.tecnocampus.tinder.profiles.application.port.in.ListProfiles;
import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import cat.tecnocampus.tinder.profiles.application.port.out.ListProfilePort;
import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ListProfilesService implements ListProfiles {

    private final ListProfilePort listProfilePort;

    ListProfilesService(ListProfilePort listProfilePort) {
        this.listProfilePort = listProfilePort;
    }

    @Override
    public List<ProfileListing> getAllProfiles() {
        return listProfilePort.loadAllProfiles();
    }

    @Override
    public ProfileListing getProfileByNickname(String nickname) {
        return listProfilePort.loadProfileByNickname(nickname)
                .orElseThrow(() -> new ProfileNotFound(nickname));
    }

    @Override
    public ProfileListing getProfileByEmail(String email) {
        return listProfilePort.loadProfileByEmail(email)
                .orElseThrow(() -> new ProfileNotFound(email));
    }


}
