package awin.com.lwozniak.transactions.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class Product {

    private String name;
    @Getter
    private BigDecimal amountPaid;
}

