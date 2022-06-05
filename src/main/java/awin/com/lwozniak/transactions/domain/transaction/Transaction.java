package awin.com.lwozniak.transactions.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class Transaction {

    private Long id;
    private LocalDate saleDate;
    private List<Product> products;
}
