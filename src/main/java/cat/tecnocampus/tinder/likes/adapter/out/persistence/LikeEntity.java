package cat.tecnocampus.tinder.likes.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.adapter.out.persistence.ProfileEntity;
import cat.tecnocampus.tinder.profiles.domain.Profile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tinder_like")
public class LikeEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProfileEntity origin;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProfileEntity target;
    private boolean matched;
    private LocalDate creationDate;
    private LocalDate matchDate;

    public LikeEntity() {
    }

    public ProfileEntity getTarget() {
        return target;
    }

    public void setTarget(ProfileEntity target) {
        this.target = target;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate date) {
        this.creationDate = date;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public ProfileEntity getOrigin() {
        return origin;
    }

    public void setOrigin(ProfileEntity origin) {
        this.origin = origin;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    @Override
    public String toString() {
        return "Like{" +
                "Id=" + Id +
                ", origin=" + origin +
                ", target=" + target +
                ", matched=" + matched +
                ", creationDate=" + creationDate +
                ", matchDate=" + matchDate +
                '}';
    }
}
