package awin.com.lwozniak.transactions.api.enrichment;

import awin.com.lwozniak.transactions.api.enrichment.mapper.EnrichedTransactionMapper;
import awin.com.lwozniak.transactions.api.enrichment.mapper.TransactionMapper;
import awin.com.lwozniak.transactions.api.enrichment.request.CollectionOfTransactionsRequest;
import awin.com.lwozniak.transactions.api.enrichment.request.SingleTransactionRequest;
import awin.com.lwozniak.transactions.api.enrichment.response.CollectionOfEnrichedTransactionsResponse;
import awin.com.lwozniak.transactions.api.enrichment.response.EnrichedTransactionDto;
import awin.com.lwozniak.transactions.api.enrichment.response.SingleEnrichedTransactionResponse;
import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import awin.com.lwozniak.transactions.service.TransactionEnricher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Transactions")
public class TransactionRestResource {

    private final TransactionMapper transactionMapper;
    private final EnrichedTransactionMapper enrichedTransactionMapper;
    private final TransactionEnricher transactionEnricher;

    @PostMapping(path = "/transactions/enrichment/single", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enrichment for single transaction")
    public ResponseEntity<SingleEnrichedTransactionResponse> enrichSingleTransaction(
            @RequestBody @NonNull SingleTransactionRequest singleTransactionRequest) {
        EnrichedTransaction enriched = transactionEnricher.enrich(
                transactionMapper.mapSingleToDomain(singleTransactionRequest.getTransaction()));
        EnrichedTransactionDto enrichedTransactionDto = enrichedTransactionMapper.mapSingleToDto(enriched);
        return ResponseEntity.ok(new SingleEnrichedTransactionResponse(enrichedTransactionDto));
    }

    @PostMapping(path = "/transactions/enrichment/collection", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enrichment collection of transactions")
    public ResponseEntity<CollectionOfEnrichedTransactionsResponse> enrichTransactions(
            @RequestBody @NonNull CollectionOfTransactionsRequest transactionListRequest) {
        List<EnrichedTransaction> enriched = transactionEnricher.enrich(
                transactionMapper.mapToDomain(transactionListRequest.getTransactions()));
        List<EnrichedTransactionDto> enrichedTransactionsDto = enrichedTransactionMapper.mapToDto(enriched);
        return ResponseEntity.ok(new CollectionOfEnrichedTransactionsResponse(enrichedTransactionsDto));
    }
}
