package br.com.devencer.update.core.domain.filters;

import static br.com.devencer.update.core.domain.error.Error.*;
import br.com.devencer.update.core.domain.dto.Product_DTO;
import br.com.devencer.update.core.domain.dto.Report_UpdatedProducts_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.mapper.Mapper;
import br.com.devencer.update.core.domain.rules.Product_Rules;
import java.util.ArrayList;
import java.util.List;

public class UpdateProductList {
  private List<Product> externalData;
  private List<Product> localData;
  private List<Product_DTO> updateList = new ArrayList<>();

  public UpdateProductList setExternalData(List<Product> products) {
    externalData = new ArrayList<>();
    externalData.addAll(products);
    return this;
  }

  public UpdateProductList setLocalData(List<Product> products) {
    localData = new ArrayList<>();
    localData.addAll(products);
    return this;
  }

  public UpdateProductList applyFilter() {
    //remove all content that is equal and is not necessary any update
    externalData.removeAll(localData);

    //Change Default rules
    prepareMakeRetainAllRespectRules();

    //if not exist in local is to add. Not to update.
    externalData.retainAll(localData);
    if (!error()) {
      reLoad();
      mapReturnList();
      updateDTO();
      return this;
    }else{
      return null;
    }
  }

  private void updateDTO() {
    Report_UpdatedProducts_DTO.getInstance().setListOfProductsUpdated(updateList);
  }

  private void mapReturnList() {
    externalData.forEach(product -> updateList.add(Mapper.getMap(product)));
  }

  private void prepareMakeRetainAllRespectRules() {
    externalData.forEach(product -> product.setRules(Product_Rules.COMPARE_ONLYBARCODE.getRule()));
    localData.forEach(product -> product.setRules(Product_Rules.COMPARE_ONLYBARCODE.getRule()));
  }

  private boolean error() {
    if (externalData.isEmpty()) {
      //"Error: Empty update table - Nothing to update."
      emptyUpdateTable("Error: Empty source/update table");
      return true;
    }
    return false;
  }

  private void reLoad() {
    externalData.forEach(product -> product.setRules(Product_Rules.DEFAULT.getRule()));
    localData.forEach(product -> product.setRules(Product_Rules.DEFAULT.getRule()));
  }

  @Override
  public String toString() {
    return "size" + externalData.size();
  }
}
