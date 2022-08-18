package br.com.devencer.update.core.domain.filters;

import static br.com.devencer.update.core.domain.error.Error.*;
import br.com.devencer.update.core.domain.dto.Product_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.mapper.Mapper;
import br.com.devencer.update.core.domain.rules.Product_Rules;
import static java.util.Objects.isNull;
import java.util.ArrayList;
import java.util.List;

class UpdateProductFilter extends Filters{
  private List<Product> externalData;
  private List<Product> localData;
  private List<Product_DTO> updateList = new ArrayList<>();
@Override
  public UpdateProductFilter setExternalData(List<Product> products) {
    externalData = new ArrayList<>();
    externalData.addAll(products);
    return this;
  }
@Override
  public UpdateProductFilter setLocalData(List<Product> products) {
    localData = new ArrayList<>();
    localData.addAll(products);
    return this;
  }
@Override
  public UpdateProductFilter filter() {
    if (localData.isEmpty() || isNull(localData)) {
      //"Error: Empty update table - Nothing to update."
      emptyUpdateTable("Error: Empty source/update table");
      return null;
    }

    if (externalData.isEmpty() || isNull(externalData)) {
      //"Error: Empty update table - Nothing to update."
      emptyUpdateTable("Error: Empty source/update table");
      return null;
    }

    boolean noAnyResult = applyFilter();

    if (noAnyResult) {
      //"Error: Empty update table - Nothing to update."
      emptyUpdateTable("Error: Empty source/update table");
    }

    return this;
  }
  @Override
  public List<Product_DTO> getListDTO() {
    mapReturnList();
    return updateList;
  }

  private void mapReturnList() {
    externalData.forEach(product -> updateList.add(Mapper.getMap(product)));
    updateList.forEach(System.out::println);
  }

  private void prepareMakeRetainAllRespectRules() {
    externalData.forEach(product -> product.setRules(Product_Rules.COMPARE_ONLYBARCODE.getRule()));
    localData.forEach(product -> product.setRules(Product_Rules.COMPARE_ONLYBARCODE.getRule()));
  }

  private boolean applyFilter() {
    //remove all content that is equal and is not necessary any update
    externalData.removeAll(localData);

    //Change Default rules
    prepareMakeRetainAllRespectRules();

    //if not exist in local is to add. Not to update.
    externalData.retainAll(localData);

    return externalData.isEmpty();
  }

}
