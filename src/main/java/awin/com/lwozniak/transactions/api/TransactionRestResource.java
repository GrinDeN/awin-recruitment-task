package awin.com.lwozniak.transactions.api;

import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import awin.com.lwozniak.transactions.service.TransactionEnricher;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
class TransactionRestResource {

    private final TransactionMapper transactionMapper;
    private final EnrichedTransactionMapper enrichedTransactionMapper;
    private final TransactionEnricher transactionEnricher;

    @PostMapping(path = "/api/transactions/enrichment/single", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleEnrichedTransactionResponse> enrichSingleTransaction(
            @RequestBody @NonNull SingleTransactionRequest singleTransactionRequest) {
        EnrichedTransaction enriched = transactionEnricher.enrich(
                transactionMapper.mapSingleToDomain(singleTransactionRequest.getTransaction()));
        EnrichedTransactionDto enrichedTransactionDto = enrichedTransactionMapper.mapSingleToDto(enriched);
        return ResponseEntity.ok(new SingleEnrichedTransactionResponse(enrichedTransactionDto));
    }

    @PostMapping(path = "/api/transactions/enrichment/collection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionOfEnrichedTransactionsResponse> enrichTransactions(
            @RequestBody @NonNull CollectionOfTransactionsRequest transactionListRequest) {
        List<EnrichedTransaction> enriched = transactionEnricher.enrich(
                transactionMapper.mapToDomain(transactionListRequest.getTransactions()));
        List<EnrichedTransactionDto> enrichedTransactionsDto = enrichedTransactionMapper.mapToDto(enriched);
        return ResponseEntity.ok(new CollectionOfEnrichedTransactionsResponse(enrichedTransactionsDto));
    }
}
