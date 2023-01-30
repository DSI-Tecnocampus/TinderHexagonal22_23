package cat.tecnocampus.tinder.likes.application.port.in;

import java.time.LocalDate;
import java.util.List;

public record ReceivedLikes(String target, List<OriginLike> originLikes) {
    public record OriginLike(
            String origin,
            boolean matched,
            LocalDate creationDate,
            LocalDate matchDate) {
    }
}
