package awin.com.lwozniak.transactions.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class SingleTransactionRequest {

    @NonNull
    private TransactionDto transaction;
}
