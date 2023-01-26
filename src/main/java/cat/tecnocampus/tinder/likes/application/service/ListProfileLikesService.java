package cat.tecnocampus.tinder.likes.application.service;

import cat.tecnocampus.tinder.likes.application.port.in.ListProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ReceivedLikes;

import java.util.List;

class ListProfileLikesService implements ListProfileLikes {

    @Override
    public List<ProfileLikes> listProfileLikes(String originEmail) {
        return null;
    }

    @Override
    public List<ReceivedLikes> listReceivedLikes(String targetEmail) {
        return null;
    }
}
