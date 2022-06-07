package awin.com.lwozniak.transactions.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EnrichedTransactionDto {

    private Long id;
    private LocalDate saleDate;
    @Builder.Default
    private List<ProductDto> products = new ArrayList<>();
    private BigDecimal totalSum;
}
