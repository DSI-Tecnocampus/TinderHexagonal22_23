package cat.tecnocampus.tinder.likes.application.port.in;

import java.time.LocalDate;
import java.util.List;

public record ProfileLikes(String origin, List<TargetLikes> targetLikes) {

    public record TargetLikes(
         String target,
         boolean matched,
         LocalDate creationDate,
         LocalDate matchDate) {
    }
}
