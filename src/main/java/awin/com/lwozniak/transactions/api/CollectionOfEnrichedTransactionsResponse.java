package awin.com.lwozniak.transactions.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class CollectionOfEnrichedTransactionsResponse {

    private List<EnrichedTransactionDto> enrichedTransactions;
}
