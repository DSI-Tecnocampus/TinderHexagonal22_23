package cat.tecnocampus.tinder.quotes.application.port.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("value")
public record ValueDTO (Long id, String quote) {
}