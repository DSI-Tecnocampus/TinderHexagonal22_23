package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.likes.application.port.out.StoreLikesPort;
import cat.tecnocampus.tinder.likes.domain.Like;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
class StoreLikesAdapter implements StoreLikesPort {
    private final LikeRepository likeRepository;

    public StoreLikesAdapter(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void storeLikes(List<Like> likes) {
        likes.stream().map(l -> MapperLikeLikeEntity.likeToLikeEntity(l)).forEach(likeRepository::save);
     }
}
