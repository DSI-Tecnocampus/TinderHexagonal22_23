package cat.tecnocampus.tinder.profiles.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.domain.Profile;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "profile")
public class ProfileEntity {
    @Id
    private String email;
    private String nickname;
    private Profile.Gender gender;
    private Profile.Gender attraction;
    private Profile.Passion passion;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Profile.Gender getGender() {
        return gender;
    }

    public void setGender(Profile.Gender gender) {
        this.gender = gender;
    }

    public Profile.Gender getAttraction() {
        return attraction;
    }

    public void setAttraction(Profile.Gender attraction) {
        this.attraction = attraction;
    }

    public Profile.Passion getPassion() {
        return passion;
    }

    public void setPassion(Profile.Passion passion) {
        this.passion = passion;
    }
}
