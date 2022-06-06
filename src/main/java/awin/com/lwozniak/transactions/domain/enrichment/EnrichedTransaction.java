package awin.com.lwozniak.transactions.domain.enrichment;

import awin.com.lwozniak.transactions.domain.transaction.Product;
import awin.com.lwozniak.transactions.domain.transaction.Transaction;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Getter
@ToString
public class EnrichedTransaction {

    private final Long id;
    private final LocalDate saleDate;
    private final List<Product> products;
    private final BigDecimal totalSum;

    public EnrichedTransaction(Transaction transaction) {
        this.id = transaction.getId();
        this.saleDate = transaction.getSaleDate();
        this.products = transaction.getProducts();
        this.totalSum = enrich();
    }

    private BigDecimal enrich() {
        return Optional.ofNullable(products)
                .map(Collection::stream)
                .map(stream -> stream
                        .map(Product::getAmountPaid)
                        .reduce((amountPaid, totalSum) -> totalSum.add(amountPaid))
                        .orElse(BigDecimal.ZERO))
                .orElse(BigDecimal.ZERO);
    }
}
