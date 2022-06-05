package awin.com.lwozniak.transactions.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
class InputTransactions {

    @Getter
    private List<TransactionDto> transactions;
}
