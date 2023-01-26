package cat.tecnocampus.tinder.likes.adapter.in.web;

import cat.tecnocampus.tinder.likes.application.port.in.AddLikedProfiles;
import cat.tecnocampus.tinder.likes.application.port.in.AddLikedProfilesCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AddLikedProfilesController {
    private final AddLikedProfiles addLikedProfiles;

    AddLikedProfilesController(AddLikedProfiles addLikedProfiles) {
        this.addLikedProfiles = addLikedProfiles;
    }

    @PostMapping("/likes")
    public void addLikes(@RequestBody AddLikedProfilesCommand likesCommand) {
        addLikedProfiles.AddLikedProfiles(likesCommand);
    }

}
