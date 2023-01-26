package cat.tecnocampus.tinder.profiles.adapter.in.web;

import cat.tecnocampus.tinder.profiles.application.port.in.ListProfileCandidates;
import cat.tecnocampus.tinder.profiles.application.port.in.ProfileListing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ListProfileCandidatesController {
    private final ListProfileCandidates listProfileCandidates;

    ListProfileCandidatesController (ListProfileCandidates listProfileCandidates) {
        this.listProfileCandidates = listProfileCandidates;
    }

    @GetMapping("/profiles/{email}/candidates")
    public List<ProfileListing> getCandidates(@PathVariable String email) {
        return listProfileCandidates.getProfileCandidates(email);
    }
}
