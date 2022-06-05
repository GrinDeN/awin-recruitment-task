package awin.com.lwozniak.transactions.api;

import awin.com.lwozniak.transactions.domain.transaction.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import java.util.List;

@Mapper(componentModel = "spring")
@MapperConfig(uses = ProductMapper.class)
public interface TransactionMapper {

    List<Transaction> map(List<TransactionDto> transactions);
}
