package br.com.devencer.update.core.domain.filters;

import br.com.devencer.update.core.domain.dto.Product_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import java.util.List;

public class Filters{
  static Filters filter;
  Filters(){};
  public static Filters create(FiltersList f) {
    filter = f.get();
    return new Filters();
  }

  public Filters setExternalData(List<Product> products) {
    filter = filter.setExternalData(products);
    return this;
  }

  public Filters setLocalData(List<Product> products) {
    filter = filter.setLocalData(products);
    return this;
  }

  public Filters filter() {
    filter = filter.filter();
    return this;
  }

  public List<Product_DTO> getListDTO() {
    return filter.getListDTO();
  }

}
