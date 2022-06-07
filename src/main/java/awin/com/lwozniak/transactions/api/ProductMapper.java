package awin.com.lwozniak.transactions.api;

import awin.com.lwozniak.transactions.domain.transaction.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<Product> mapToDomain(List<ProductDto> products);

    List<ProductDto> mapToDto(List<Product> productDtos);
}
