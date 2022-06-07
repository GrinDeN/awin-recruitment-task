package awin.com.lwozniak.transactions.api.enrichment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public
class CollectionOfEnrichedTransactionsResponse {

    private List<EnrichedTransactionDto> enrichedTransactions;
}
