package br.com.devencer.update.core.domain.mapper;

import br.com.devencer.update.core.domain.dto.Product_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import org.modelmapper.ModelMapper;

public class Mapper {

  public static Product_DTO getMap(Product product) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(product, Product_DTO.class);
  }
}
