package cat.tecnocampus.tinder.profiles.application.service;

import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import cat.tecnocampus.tinder.profiles.domain.Profile;

public class MapperProfileProfileListing {

    public static Profile profileListingToProfile (ProfileListing profileListing) {
        Profile profile = new Profile();
        profile.setEmail(profileListing.email());
        profile.setNickname(profileListing.nickname());
        profile.setGender(profileListing.gender());
        profile.setAttraction(profileListing.attraction());
        profile.setPassion(profileListing.passion());

        return profile;
    }

    public static ProfileListing profileToProfileListing(Profile profile) {
        ProfileListing profileListing =
                new ProfileListing(profile.getEmail(),
                        profile.getNickname(),
                        profile.getGender(),
                        profile.getAttraction(),
                        profile.getPassion());
        return profileListing;
    }
}
