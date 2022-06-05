package awin.com.lwozniak.transactions.service;

import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import awin.com.lwozniak.transactions.domain.transaction.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionEnricherImpl implements TransactionEnricher {

    @Override
    public List<EnrichedTransaction> enrich(List<Transaction> transactions) {
        return transactions.stream()
                .map(EnrichedTransaction::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
