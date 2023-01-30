package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.likes.application.port.in.ListProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ReceivedLikes;
import cat.tecnocampus.tinder.likes.application.port.out.ListProfileLikesPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ListProfileLikeAdapter implements ListProfileLikes, ListProfileLikesPort {
    private final LikeRepository likeRepository;

    public ListProfileLikeAdapter(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public ProfileLikes listProfileLikes(String originEmail) {
        List<LikeEntity>  likes = likeRepository.findByOriginEmail(originEmail);

        return MapperLikeEntityListProfileLikes.likeEntityListToProfileLikes(likes);
    }

    @Override
    public ReceivedLikes listReceivedLikes(String targetEmail) {
        List<LikeEntity>  likes = likeRepository.findByTargetEmail(targetEmail);

        return MapperLikeEntityListProfileLikes.likeEntityListToReceivedLikes(likes);
    }
}
