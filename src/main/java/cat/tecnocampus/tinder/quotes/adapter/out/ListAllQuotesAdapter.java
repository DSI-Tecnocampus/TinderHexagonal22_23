package cat.tecnocampus.tinder.quotes.adapter.out;

import cat.tecnocampus.tinder.quotes.application.port.in.ListAllQuotes;
import cat.tecnocampus.tinder.quotes.application.port.in.QuoteDTO;
import cat.tecnocampus.tinder.quotes.application.port.in.ValueDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
class ListAllQuotesAdapter implements ListAllQuotes {
    private final WebClient webClient;

    public ListAllQuotesAdapter(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<ValueDTO> listAllQuotes() {
        List<QuoteDTO> quotes = webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<QuoteDTO>>() {})
                .block();
        return quotes.stream().map(QuoteDTO::value).collect(Collectors.toList());
    }
}
