package awin.com.lwozniak.transactions.service;

import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import awin.com.lwozniak.transactions.domain.transaction.Transaction;

import java.util.List;

public interface TransactionEnricher {

    List<EnrichedTransaction> enrich(List<Transaction> transactions);
}
