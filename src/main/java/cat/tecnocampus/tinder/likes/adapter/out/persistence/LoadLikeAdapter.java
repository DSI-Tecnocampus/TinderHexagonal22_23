package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.likes.application.port.out.LoadLikesByOriginPort;
import cat.tecnocampus.tinder.likes.domain.Like;
import cat.tecnocampus.tinder.profiles.domain.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class LoadLikeAdapter implements LoadLikesByOriginPort {

    private final LikeRepository likeRepository;

    LoadLikeAdapter(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public List<Like> listLikesByOrigin(Profile origin) {
        return likeRepository.findByOriginEmail(origin.getEmail()).stream().map(MapperLikeLikeEntity::likeEntityToLike)
                .collect(Collectors.toList());
    }
}
