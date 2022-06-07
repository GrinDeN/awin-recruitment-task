package awin.com.lwozniak.transactions.api.enrichment.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public
class SingleTransactionRequest {

    @NonNull
    private TransactionDto transaction;
}
