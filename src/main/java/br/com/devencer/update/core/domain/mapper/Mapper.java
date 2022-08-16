package br.com.devencer.update.core.domain.mapper;

import br.com.devencer.update.core.domain.dto.Product_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Mapper {
  @Autowired
  private ModelMapper modelMapper;

  public Product_DTO getMap(Product product) {
    return modelMapper.map(product, Product_DTO.class);
  }
}
