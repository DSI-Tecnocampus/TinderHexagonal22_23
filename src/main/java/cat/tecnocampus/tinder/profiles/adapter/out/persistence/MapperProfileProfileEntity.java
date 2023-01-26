package cat.tecnocampus.tinder.profiles.adapter.out.persistence;

import cat.tecnocampus.tinder.profiles.domain.Profile;

public class MapperProfileProfileEntity {

    public static Profile profileEntityToProfile(ProfileEntity profileEntity) {
        Profile profile = new Profile();
        profile.setEmail(profileEntity.getEmail());
        profile.setNickname(profileEntity.getNickname());
        profile.setPassion(profileEntity.getPassion());
        profile.setGender(profileEntity.getGender());
        profile.setAttraction(profileEntity.getAttraction());

        return profile;
    }

    public static ProfileEntity profileToProfileEntity(Profile profile) {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEmail(profile.getEmail());
        profileEntity.setNickname(profile.getNickname());
        profileEntity.setPassion(profile.getPassion());
        profileEntity.setGender(profile.getGender());
        profileEntity.setAttraction(profile.getAttraction());

        return profileEntity;
    }
}
