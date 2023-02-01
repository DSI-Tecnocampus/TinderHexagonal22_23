package cat.tecnocampus.tinder.quotes.adapter.in;

import cat.tecnocampus.tinder.quotes.application.port.in.GetQuoteById;
import cat.tecnocampus.tinder.quotes.application.port.in.GetRandomQuote;
import cat.tecnocampus.tinder.quotes.application.port.in.ListAllQuotes;
import cat.tecnocampus.tinder.quotes.application.port.in.ValueDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/quotes")
@RestController
class QuoteRestController {
    private final GetQuoteById getQuoteById;
    private final GetRandomQuote getRandomQuote;
    private final ListAllQuotes listAllQuotes;

    public QuoteRestController(GetQuoteById getQuoteById, GetRandomQuote getRandomQuote, ListAllQuotes listAllQuotes) {
        this.getQuoteById = getQuoteById;
        this.getRandomQuote = getRandomQuote;
        this.listAllQuotes = listAllQuotes;
    }

    @GetMapping("/{id}")
    public ValueDTO getQuoteId(@PathVariable Long id) {
        return getQuoteById.getQuoteById(id);
    }

    @GetMapping("/random")
    public ValueDTO getQuoteRandom() {
        return getRandomQuote.getRandomQuote();
    }

    @GetMapping("")
    public List<ValueDTO> getQuotes() {
        return listAllQuotes.listAllQuotes();
    }
}
