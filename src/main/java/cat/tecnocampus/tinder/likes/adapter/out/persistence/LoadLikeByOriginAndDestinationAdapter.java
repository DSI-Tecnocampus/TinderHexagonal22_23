package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.likes.application.port.out.LoadLikeByOriginAndDestinationPort;
import cat.tecnocampus.tinder.likes.application.service.exception.LikeNotFoundException;
import cat.tecnocampus.tinder.likes.domain.Like;
import cat.tecnocampus.tinder.profiles.adapter.out.persistence.MapperProfileProfileEntity;
import cat.tecnocampus.tinder.profiles.domain.Profile;

public class LoadLikeByOriginAndDestinationAdapter implements LoadLikeByOriginAndDestinationPort {
    private final LikeRepository likeRepository;

    public LoadLikeByOriginAndDestinationAdapter(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like loadLikeByOriginAndDestination(Profile origin, Profile target) {
        LikeEntity likeEntity = likeRepository.findByOriginAndTarget(MapperProfileProfileEntity.profileToProfileEntity(origin),
                MapperProfileProfileEntity.profileToProfileEntity(target))
                .orElseThrow(() -> new LikeNotFoundException());
        return MapperLikeLikeEntity.likeEntityToLike(likeEntity);
    }
}
