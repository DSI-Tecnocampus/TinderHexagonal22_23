package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.likes.domain.Like;
import cat.tecnocampus.tinder.profiles.adapter.out.persistence.MapperProfileProfileEntity;

public class MapperLikeLikeEntity {

    public static LikeEntity likeToLikeEntity(Like like) {
        LikeEntity likeEntity = new LikeEntity();

        likeEntity.setId(like.getId());
        likeEntity.setCreationDate(like.getCreationDate());
        likeEntity.setMatched(like.isMatched());
        likeEntity.setMatchDate(like.getMatchDate());
        likeEntity.setId(like.getId());
        likeEntity.setTarget(MapperProfileProfileEntity.profileToProfileEntity(like.getTarget()));
        likeEntity.setOrigin(MapperProfileProfileEntity.profileToProfileEntity(like.getOrigin()));

        return likeEntity;
    }

    public static Like likeEntityToLike(LikeEntity likeEntity) {
        Like like = new Like();

        like.setId(likeEntity.getId());
        like.setCreationDate(likeEntity.getCreationDate());
        like.setMatched(likeEntity.isMatched());
        like.setMatchDate(likeEntity.getMatchDate());
        like.setId(likeEntity.getId());
        like.setTarget(MapperProfileProfileEntity.profileEntityToProfile(likeEntity.getTarget()));
        like.setOrigin(MapperProfileProfileEntity.profileEntityToProfile(likeEntity.getOrigin()));

        return like;
    }
}
