package awin.com.lwozniak.transactions.api;

import awin.com.lwozniak.transactions.domain.enrichment.EnrichedTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import java.util.List;

@Mapper(componentModel = "spring")
@MapperConfig(uses = ProductMapper.class)
public interface EnrichedTransactionMapper {

    EnrichedTransactionDto mapSingleToDto(EnrichedTransaction enrichedTransaction);

    List<EnrichedTransactionDto> mapToDto(List<EnrichedTransaction> enrichedTransactions);
}
