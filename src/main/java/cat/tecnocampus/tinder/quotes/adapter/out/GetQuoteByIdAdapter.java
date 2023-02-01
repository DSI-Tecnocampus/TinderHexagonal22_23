package cat.tecnocampus.tinder.quotes.adapter.out;

import cat.tecnocampus.tinder.quotes.application.port.in.GetQuoteById;
import cat.tecnocampus.tinder.quotes.application.port.in.QuoteDTO;
import cat.tecnocampus.tinder.quotes.application.port.in.ValueDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
class GetQuoteByIdAdapter implements GetQuoteById {
    private final WebClient webClient;

    public GetQuoteByIdAdapter(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public ValueDTO getQuoteById(Long id) {
        var quote = webClient.get()
                .uri(String.join("", "/", id.toString()))
                .retrieve()
                .bodyToMono(QuoteDTO.class)
                .block();
        System.out.println(quote.type());
        //System.out.println(quote.valueDTO().quote());
        return quote.value();
    }
}
