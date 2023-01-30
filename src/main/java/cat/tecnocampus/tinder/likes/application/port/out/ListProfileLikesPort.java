package cat.tecnocampus.tinder.likes.application.port.out;

import cat.tecnocampus.tinder.likes.application.port.in.ProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ReceivedLikes;

import java.util.List;

public interface ListProfileLikesPort {

    ProfileLikes listProfileLikes(String originEmail);

    ReceivedLikes listReceivedLikes(String targetEmail);

}
