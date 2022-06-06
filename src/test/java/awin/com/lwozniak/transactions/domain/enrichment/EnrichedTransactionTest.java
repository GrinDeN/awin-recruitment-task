package awin.com.lwozniak.transactions.domain.enrichment;

import awin.com.lwozniak.transactions.domain.transaction.Product;
import awin.com.lwozniak.transactions.domain.transaction.Transaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EnrichedTransactionTest {

    private static final BigDecimal APPLE_AMOUNT_PAID = new BigDecimal("1.55");
    private static final BigDecimal PEAR_AMOUNT_PAID = new BigDecimal("2.55");

    @Test
    void creating_enrichedTransaction_should_calculate_total_sum_of_all_products() {
        // given
        Transaction transaction = createTransaction(withProducts());
        BigDecimal expectedTotalSum = APPLE_AMOUNT_PAID.add(PEAR_AMOUNT_PAID);

        // when
        EnrichedTransaction enriched = new EnrichedTransaction(transaction);

        // then
        assertThat(enriched)
                .isNotNull()
                .extracting("totalSum")
                .isEqualTo(expectedTotalSum);
    }

    @Test
    void creating_enrichedTransaction_should_calculate_total_sum_as_zero_if_products_are_empty() {
        // given
        Transaction transaction = createTransaction(new ArrayList<>());

        // when
        EnrichedTransaction enriched = new EnrichedTransaction(transaction);

        // then
        assertThat(enriched)
                .isNotNull()
                .extracting("totalSum")
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void creating_enrichedTransaction_should_calculate_total_sum_as_zero_if_products_are_null() {
        // given
        Transaction transaction = createTransaction(null);

        // when
        EnrichedTransaction enriched = new EnrichedTransaction(transaction);

        // then
        assertThat(enriched)
                .isNotNull()
                .extracting("totalSum")
                .isEqualTo(BigDecimal.ZERO);
    }

    private Transaction createTransaction(List<Product> products) {
        return new Transaction(1L, LocalDate.ofYearDay(2022, 185), products);
    }

    private List<Product> withProducts() {
        return Arrays.asList(
                new Product("apple", APPLE_AMOUNT_PAID),
                new Product("pear", PEAR_AMOUNT_PAID)
        );
    }

}
