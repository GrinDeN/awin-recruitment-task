package awin.com.lwozniak.transactions.service;

import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import awin.com.lwozniak.transactions.domain.transaction.Product;
import awin.com.lwozniak.transactions.domain.transaction.Transaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionEnricherImplTest {

    private static final BigDecimal APPLE_AMOUNT_PAID = new BigDecimal("1.55");
    private static final BigDecimal PEAR_AMOUNT_PAID = new BigDecimal("2.44");
    private static final BigDecimal TOMATO_AMOUNT_PAID = new BigDecimal("3.22");
    private static final BigDecimal POTATO_AMOUNT_PAID = new BigDecimal("5.33");

    private final TransactionEnricher transactionEnricher = new TransactionEnricherImpl();

    @Test
    void transactionEnricher_should_calculate_proper_sum_for_all_given_transactions() {
        // given
        List<Transaction> transactions = createProperTransactions();
        // when
        List<EnrichedTransaction> enrichedTransactions = transactionEnricher.enrich(transactions);
        // then
        assertThat(enrichedTransactions)
                .isNotNull()
                .hasSameSizeAs(transactions)
                .map(EnrichedTransaction::getTotalSum)
                .hasSameElementsAs(expectedTotalSums());
    }

    @Test
    void transactionEnricher_should_calculate_proper_sum_for_given_transactions_one_with_empty_products() {
        // given
        List<Transaction> transactions = createTransactionsOneWithEmptyProducts();
        // when
        List<EnrichedTransaction> enrichedTransactions = transactionEnricher.enrich(transactions);
        // then
        assertThat(enrichedTransactions)
                .isNotNull()
                .hasSameSizeAs(transactions)
                .map(EnrichedTransaction::getTotalSum)
                .hasSameElementsAs(expectedTotalSumsWithOneEmpty());
    }

    @Test
    void transactionEnricher_should_calculate_proper_sum_for_given_transactions_one_with_null_products() {
        // given
        List<Transaction> transactions = createTransactionsOneWithNullProducts();
        // when
        List<EnrichedTransaction> enrichedTransactions = transactionEnricher.enrich(transactions);
        // then
        assertThat(enrichedTransactions)
                .isNotNull()
                .hasSameSizeAs(transactions)
                .map(EnrichedTransaction::getTotalSum)
                .hasSameElementsAs(expectedTotalSumsWithOneNull());
    }

    private List<BigDecimal> expectedTotalSumsWithOneNull() {
        return Arrays.asList(
                TOMATO_AMOUNT_PAID.add(POTATO_AMOUNT_PAID),
                BigDecimal.ZERO
        );
    }

    private List<BigDecimal> expectedTotalSumsWithOneEmpty() {
        return Arrays.asList(
                APPLE_AMOUNT_PAID.add(PEAR_AMOUNT_PAID),
                BigDecimal.ZERO
        );
    }

    private List<Transaction> createProperTransactions() {
        return Arrays.asList(
                fruitsTransaction(),
                vegetablesTransaction()
        );
    }

    private List<Transaction> createTransactionsOneWithEmptyProducts() {
        return Arrays.asList(
                fruitsTransaction(),
                emptyProductsTransaction()
        );
    }

    private List<Transaction> createTransactionsOneWithNullProducts() {
        return Arrays.asList(
                vegetablesTransaction(),
                nullProductsTransaction()
        );
    }

    private Transaction vegetablesTransaction() {
        return new Transaction(1L, LocalDate.of(2022, 5, 6), vegetables());
    }

    private Transaction fruitsTransaction() {
        return new Transaction(22L, LocalDate.of(2022, 5, 7), fruits());
    }

    private Transaction nullProductsTransaction() {
        return new Transaction(1234L, LocalDate.of(2022, 5, 10), null);
    }

    private Transaction emptyProductsTransaction() {
        return new Transaction(123L, LocalDate.of(2022, 5, 8), new ArrayList<>());
    }

    private List<Product> fruits() {
        return Arrays.asList(
                new Product("apple", APPLE_AMOUNT_PAID),
                new Product("pear", PEAR_AMOUNT_PAID)
        );
    }

    private List<Product> vegetables() {
        return Arrays.asList(
                new Product("tomato", TOMATO_AMOUNT_PAID),
                new Product("potato", POTATO_AMOUNT_PAID)
        );
    }

    private List<BigDecimal> expectedTotalSums() {
        return Arrays.asList(
                APPLE_AMOUNT_PAID.add(PEAR_AMOUNT_PAID),
                TOMATO_AMOUNT_PAID.add(POTATO_AMOUNT_PAID)
        );
    }
}