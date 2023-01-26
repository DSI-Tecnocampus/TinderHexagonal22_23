package cat.tecnocampus.tinder.profiles.application.port.in;

import cat.tecnocampus.tinder.profiles.domain.Profile;

public record ProfileListing(String email, String nickname, Profile.Gender gender,
                             Profile.Gender attraction, Profile.Passion passion) {
}
