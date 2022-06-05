package awin.com.lwozniak.transactions;

import awin.com.lwozniak.transactions.api.TransactionDto;
import awin.com.lwozniak.transactions.api.TransactionMapper;
import awin.com.lwozniak.transactions.api.TransactionReader;
import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import awin.com.lwozniak.transactions.domain.transaction.Transaction;
import awin.com.lwozniak.transactions.service.TransactionEnricher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class TransactionsApplication implements CommandLineRunner {

	@Autowired
	private TransactionReader transactionReader;

	@Autowired
	private TransactionMapper transactionMapper;
	@Autowired
	private TransactionEnricher transactionEnricher;

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<TransactionDto> readTransactions = read();
		List<Transaction> transactions = map(readTransactions);
		List<EnrichedTransaction> enrichedTransactions = enrich(transactions);
		log.info("Enriched transactions:" + System.lineSeparator() + "{}", enrichedTransactions);
	}

	private List<TransactionDto> read() {
		return transactionReader.read();
	}

	private List<Transaction> map(List<TransactionDto> readTransactions) {
		return transactionMapper.map(readTransactions);
	}

	private List<EnrichedTransaction> enrich(List<Transaction> transactions) {
		return transactionEnricher.enrich(transactions);
	}
}
