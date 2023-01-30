package cat.tecnocampus.tinder.likes.application.port.in;

import java.util.List;

public interface ListProfileLikes {
    ProfileLikes listProfileLikes(String originEmail);

    ReceivedLikes listReceivedLikes(String targetEmail);
}
