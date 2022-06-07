package awin.com.lwozniak.transactions.api.enrichment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public
class SingleEnrichedTransactionResponse {

    private EnrichedTransactionDto enrichedTransaction;
}
