package awin.com.lwozniak.transactions.api.enrichment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private String name;
    private BigDecimal amountPaid;
}
