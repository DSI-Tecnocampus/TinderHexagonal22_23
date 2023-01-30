package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.likes.application.port.in.ProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ReceivedLikes;

import java.util.ArrayList;
import java.util.List;

public class MapperLikeEntityListProfileLikes {

    public static ProfileLikes likeEntityListToProfileLikes(List<LikeEntity> likeEntities) {
        List<ProfileLikes.TargetLikes> mylikes = new ArrayList<>();
        likeEntities.forEach(le -> mylikes.add(convertToOriginLikes(le)));
        return new ProfileLikes(likeEntities.get(0).getOrigin().getEmail(), mylikes);
    }

    private static ProfileLikes.TargetLikes convertToOriginLikes(LikeEntity le) {
        return new ProfileLikes.TargetLikes(le.getTarget().getEmail(), le.isMatched(), le.getCreationDate(), le.getMatchDate());
    }

    public static ReceivedLikes likeEntityListToReceivedLikes(List<LikeEntity> likeEntities) {
        List<ReceivedLikes.OriginLike> mylikes = new ArrayList<>();
        likeEntities.forEach(le -> mylikes.add(convertToDestinationLikes(le)));
        return new ReceivedLikes(likeEntities.get(0).getTarget().getEmail(), mylikes);
    }

    private static ReceivedLikes.OriginLike convertToDestinationLikes(LikeEntity le) {
        return new ReceivedLikes.OriginLike(le.getOrigin().getEmail(), le.isMatched(), le.getCreationDate(), le.getMatchDate());
    }
}
