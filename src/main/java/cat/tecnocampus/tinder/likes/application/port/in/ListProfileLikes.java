package cat.tecnocampus.tinder.likes.application.port.in;

import java.util.List;

public interface ListProfileLikes {
    List<ProfileLikes> listProfileLikes(String originEmail);

    List<ReceivedLikes> listReceivedLikes(String targetEmail);
}
