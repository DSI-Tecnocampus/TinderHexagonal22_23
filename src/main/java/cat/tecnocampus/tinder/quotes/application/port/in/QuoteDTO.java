package cat.tecnocampus.tinder.quotes.application.port.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuoteDTO (String type,ValueDTO value) {
}