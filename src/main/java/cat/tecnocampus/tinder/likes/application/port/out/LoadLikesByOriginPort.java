package cat.tecnocampus.tinder.likes.application.port.out;

import cat.tecnocampus.tinder.likes.domain.Like;
import cat.tecnocampus.tinder.profiles.domain.Profile;

import java.util.List;

public interface LoadLikesByOriginPort {
    List<Like> listLikesByOrigin(Profile origin);
}
