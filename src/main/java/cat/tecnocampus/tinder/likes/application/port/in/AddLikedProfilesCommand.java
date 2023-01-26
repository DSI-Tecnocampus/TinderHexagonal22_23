package cat.tecnocampus.tinder.likes.application.port.in;

import java.util.List;

public record AddLikedProfilesCommand(
        String origin, List<String> targets) {
}
