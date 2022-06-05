package awin.com.lwozniak.transactions.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class ProductDto {

    private String name;
    private BigDecimal amountPaid;
}
