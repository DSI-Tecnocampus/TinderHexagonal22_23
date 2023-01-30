package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.adapter.out.persistence.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    Optional<LikeEntity> findByOriginAndTarget(ProfileEntity origin, ProfileEntity target);

    List<LikeEntity> findByOriginEmail(String origin);

    List<LikeEntity> findByTargetEmail(String target);

}
