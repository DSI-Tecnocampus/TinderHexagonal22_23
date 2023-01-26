package cat.tecnocampus.tinder.likes.application.service;

import cat.tecnocampus.tinder.likes.application.port.in.AddLikedProfiles;
import cat.tecnocampus.tinder.likes.application.port.in.AddLikedProfilesCommand;
import cat.tecnocampus.tinder.likes.application.port.out.LoadLikeByOriginAndDestinationPort;
import cat.tecnocampus.tinder.likes.application.port.out.StoreLikesPort;
import cat.tecnocampus.tinder.likes.domain.Like;
import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import cat.tecnocampus.tinder.profiles.application.port.out.ListProfilePort;
import cat.tecnocampus.tinder.profiles.application.service.MapperProfileProfileListing;
import cat.tecnocampus.tinder.profiles.application.service.exception.ProfileNotFound;
import cat.tecnocampus.tinder.profiles.domain.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
class AddLikedProfilesService implements AddLikedProfiles {
    private final ListProfilePort listProfilePort;
    private final StoreLikesPort storeLikesPort;
    private final LoadLikeByOriginAndDestinationPort loadLikeByOriginAndDestinationPort;

    AddLikedProfilesService(ListProfilePort listProfilePort, StoreLikesPort storeLikesPort,
                            LoadLikeByOriginAndDestinationPort loadLikeByOriginAndDestinationPort) {
        this.listProfilePort = listProfilePort;
        this.storeLikesPort = storeLikesPort;
        this.loadLikeByOriginAndDestinationPort = loadLikeByOriginAndDestinationPort;
    }

    @Override
    public void AddLikedProfiles(AddLikedProfilesCommand command) {
        ProfileListing originListing = listProfilePort.loadProfileByEmail(command.origin())
                .orElseThrow(() -> new ProfileNotFound(command.origin()));
        Profile origin = MapperProfileProfileListing.profileListingToProfile(originListing);
        List<Like> likes =
                command.targets().stream().map(email -> listProfilePort.loadProfileByEmail(email).orElseThrow(() -> new ProfileNotFound(email)))
                        .map(MapperProfileProfileListing::profileListingToProfile)
                        .filter(origin::isCompatible) 			//make sure it is compatible
                        .map(origin::createAndMatchLike)		//create likes
                        .collect(Collectors.toList());
        origin.addLikes(likes);
        List<Like> updatedTargetMatchingLikes = updateTargetMatchingLikes(origin, likes);
        storeLikesPort.storeLikes(likes);
        storeLikesPort.storeLikes(updatedTargetMatchingLikes);
    }

    private List<Like> updateTargetMatchingLikes(Profile origin, List<Like> likes) {
        return likes.stream().filter(Like::isMatched)
                .map(l -> loadLikeByOriginAndDestinationPort.loadLikeByOriginAndDestination(l.getTarget(), origin))
                .map(Like::match).collect(Collectors.toList());
    }

}
