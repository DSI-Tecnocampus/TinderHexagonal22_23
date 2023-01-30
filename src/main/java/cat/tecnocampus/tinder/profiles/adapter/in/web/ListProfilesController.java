package cat.tecnocampus.tinder.profiles.adapter.in.web;

import cat.tecnocampus.tinder.profiles.application.port.in.ListProfiles;
import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
class ListProfilesController {
    private final ListProfiles listProfiles;

    public ListProfilesController(ListProfiles listProfiles) {
        this.listProfiles = listProfiles;
    }

    @GetMapping("/profiles")
    public List<ProfileListing> getAllProfiles() {
        return listProfiles.getAllProfiles();
    }

    @GetMapping("/profiles/email/{email}")
    public ProfileListing getProfileByEmail(@PathVariable String email) {
        return listProfiles.getProfileByEmail(email);
    }

    @GetMapping("/profiles/nickname/{nickname}")
    public ProfileListing getProfileByNickname(@PathVariable String nickname) {
        return listProfiles.getProfileByNickname(nickname);
    }

    @GetMapping("/profiles/me")
    public ProfileListing getProfileMe(Principal principal) {
        return listProfiles.getProfileByEmail(principal.getName());
    }
}
