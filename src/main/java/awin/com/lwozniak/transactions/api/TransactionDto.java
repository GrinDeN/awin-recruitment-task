package awin.com.lwozniak.transactions.api;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private Long id;
    private LocalDate saleDate;
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<ProductDto> products;
}
