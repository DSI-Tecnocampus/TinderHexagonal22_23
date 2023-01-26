package cat.tecnocampus.tinder.likes.application.port.out;

import cat.tecnocampus.tinder.likes.domain.Like;

import java.util.List;

public interface StoreLikesPort {
    public void storeLikes(List<Like> likes);
}
