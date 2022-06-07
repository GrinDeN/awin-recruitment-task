package awin.com.lwozniak.transactions.api.enrichment.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public
class CollectionOfTransactionsRequest {

    @NonNull
    private List<TransactionDto> transactions;
}
