package cat.tecnocampus.tinder.likes.application.port.out;

import cat.tecnocampus.tinder.likes.domain.Like;
import cat.tecnocampus.tinder.profiles.domain.Profile;

public interface LoadLikeByOriginAndDestinationPort {
    public Like loadLikeByOriginAndDestination(Profile origin, Profile target);
}
