package awin.com.lwozniak.transactions.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Product {

    private String name;
    private BigDecimal amountPaid;
}

