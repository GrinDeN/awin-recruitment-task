package awin.com.lwozniak.transactions.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class SingleEnrichedTransactionResponse {

    private EnrichedTransactionDto enrichedTransaction;
}
