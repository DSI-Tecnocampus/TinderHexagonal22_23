package cat.tecnocampus.tinder.likes.adapter.in.web;

import cat.tecnocampus.tinder.likes.application.port.in.ListProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ProfileLikes;
import cat.tecnocampus.tinder.likes.application.port.in.ReceivedLikes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
class ListProfileLikesController {
    private final ListProfileLikes listProfileLikes;

    ListProfileLikesController(ListProfileLikes listProfileLikes) {
        this.listProfileLikes = listProfileLikes;
    }

    @GetMapping("/profiles/me/likes")
    public ProfileLikes listOriginLikes(Principal principal) {
        return listProfileLikes.listProfileLikes(principal.getName());
    }

    @GetMapping("/profiles/me/likedTo")
    public ReceivedLikes listTargetLikes(Principal principal) {
        return listProfileLikes.listReceivedLikes(principal.getName());
    }
}
