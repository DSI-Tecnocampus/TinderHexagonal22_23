package cat.tecnocampus.tinder.likes.application.port.in;

import java.time.LocalDate;
import java.util.List;

public record ProfileLikes(String origin, List<OriginLikes> mylikes) {

    public record OriginLikes(
         String target,
         boolean matched,
         LocalDate creationDate,
         LocalDate matchDate) {
    }
}
