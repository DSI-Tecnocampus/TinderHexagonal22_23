package cat.tecnocampus.tinder.likes.domain;

import cat.tecnocampus.tinder.profiles.domain.Profile;

import java.time.LocalDate;

public class Like {
    private Long Id;

    private Profile origin;
    private Profile target;
    private boolean matched;
    private LocalDate creationDate;
    private LocalDate matchDate;

    public Like() {
    }

    public Like(Profile origin, Profile target) {
        this.origin = origin;
        this.target = target;
        creationDate = LocalDate.now();
        matched = false;
        matchDate = null;
    }

    public Profile getTarget() {
        return target;
    }

    public void setTarget(Profile target) {
        this.target = target;
    }

    public boolean isMatched() {
        return matched;
    }

    public Like match() {
        this.matched = true;
        this.matchDate = LocalDate.now();
        return this;
    }

    public void unmatch() {
        this.matched = false;
        this.matchDate = null;
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

    public Profile getOrigin() {
        return origin;
    }

    public void setOrigin(Profile origin) {
        this.origin = origin;
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
