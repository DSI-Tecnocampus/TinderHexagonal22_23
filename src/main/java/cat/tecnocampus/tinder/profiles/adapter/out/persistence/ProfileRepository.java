package cat.tecnocampus.tinder.profiles.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    @Query("""
            select new cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing(
                            p.email, p.nickname, p.gender, p.attraction, p.passion)
            from profile p 
            where p.nickname = :nickname
        """)
    Optional<ProfileListing> getByNickname(@Param("nickname") String nickname);

    @Query("""
            select new cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing(
                            p.email, p.nickname, p.gender, p.attraction, p.passion)
            from profile p 
            where p.email = :email
        """)
    Optional<ProfileListing> getByEmail(@Param("email") String email);

    @Query("""
            select new cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing(
                            p.email, p.nickname, p.gender, p.attraction, p.passion)
                            from profile p
        """)
    List<ProfileListing> findAllListing();


}
