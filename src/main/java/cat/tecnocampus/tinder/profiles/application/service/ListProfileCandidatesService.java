package cat.tecnocampus.tinder.profiles.application.service;

import cat.tecnocampus.tinder.profiles.application.port.in.ListProfileCandidates;
import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import cat.tecnocampus.tinder.profiles.application.port.out.ListProfilePort;
import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileNotFound;
import cat.tecnocampus.tinder.profiles.domain.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class ListProfileCandidatesService implements ListProfileCandidates {
    private final ListProfilePort listProfilePort;

    ListProfileCandidatesService(ListProfilePort listProfilePort) {
        this.listProfilePort = listProfilePort;
    }

    @Override
    public List<ProfileListing> getProfileCandidates(String email) {
        ProfileListing profileListing = listProfilePort.loadProfileByEmail(email)
                .orElseThrow(() -> new ProfileNotFound(email));
        Profile user = MapperProfileProfileListing.profileListingToProfile(profileListing);

        return listProfilePort.loadAllProfiles().stream()
                .map(MapperProfileProfileListing::profileListingToProfile)
                .filter(user::isCompatible)
                .map(MapperProfileProfileListing::profileToProfileListing)
                .collect(Collectors.toList());
    }
}
