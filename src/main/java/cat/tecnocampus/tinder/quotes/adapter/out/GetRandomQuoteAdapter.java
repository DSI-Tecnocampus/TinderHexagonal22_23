package cat.tecnocampus.tinder.quotes.adapter.out;

import cat.tecnocampus.tinder.quotes.application.port.in.GetRandomQuote;
import cat.tecnocampus.tinder.quotes.application.port.in.QuoteDTO;
import cat.tecnocampus.tinder.quotes.application.port.in.ValueDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
class GetRandomQuoteAdapter implements GetRandomQuote {
    private final WebClient webClient;


    GetRandomQuoteAdapter(WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public ValueDTO getRandomQuote() {
        var quote = webClient.get()
                .uri(String.join("", "/random"))
                .retrieve()
                .bodyToMono(QuoteDTO.class)
                .block();
        return quote.value();
    }
}
