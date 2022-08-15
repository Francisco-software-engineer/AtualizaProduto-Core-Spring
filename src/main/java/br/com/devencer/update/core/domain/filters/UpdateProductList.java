package br.com.devencer.update.core.domain.filters;

import static br.com.devencer.update.core.domain.error.Error.*;

import br.com.devencer.update.core.domain.dto.Product_DTO;
import br.com.devencer.update.core.domain.dto.Report_UpdatedProducts_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.mapper.Mapper;
import br.com.devencer.update.core.domain.rules.Product_Rules;
import br.com.devencer.update.driven.local.LocalData;
import br.com.devencer.update.driven.sourceupdate.UpdateData;
import java.util.ArrayList;
import java.util.List;

public class UpdateProductList {
  private List<Product> allDataFromExternalSource = new ArrayList<>();
  private List<Product> allDataFromLocalSource = new ArrayList<>();

  private List<Product> local = new ArrayList<>();
  private List<Product_DTO> returnList = new ArrayList<>();

  public void applyFilter() {
    if (!error()) {
      mapReturnList();
      updateDTO();
    }
  }

  private void updateDTO() {
    Report_UpdatedProducts_DTO.getInstance().setListOfProductsUpdated(returnList);
  }

  private void mapReturnList() {
    allDataFromExternalSource.forEach(product -> returnList.add(Mapper.getMap(product)));
  }

  public UpdateProductList(UpdateData externalSource, LocalData localSource) {
    reLoad();
    allDataFromExternalSource.addAll(externalSource.getProductList());
    allDataFromLocalSource.addAll(localSource.getProductList());

    //remove all content that is equal and is not necessary any update
    allDataFromExternalSource.removeAll(allDataFromLocalSource);

    //Change Default rules
    prepareMakeRetainAllRespectRules();
    //if not exist in local is to add. Not to update.
    allDataFromExternalSource.retainAll(allDataFromLocalSource);
  }

  private void prepareMakeRetainAllRespectRules() {
    allDataFromExternalSource.forEach(product -> product.setRules(Product_Rules.COMPARE_ONLYBARCODE.getRule()));
    allDataFromLocalSource.forEach(product -> product.setRules(Product_Rules.COMPARE_ONLYBARCODE.getRule()));
  }

  private boolean error() {
    if (allDataFromExternalSource.isEmpty()) {
      //"Error: Empty update table - Nothing to update."
      emptyUpdateTable("Error: Empty source/update table");
      return true;
    }
    return false;
  }

  private void reLoad() {
    allDataFromExternalSource.forEach(product -> product.setRules(Product_Rules.DEFAULT.getRule()));
    allDataFromLocalSource.forEach(product -> product.setRules(Product_Rules.DEFAULT.getRule()));
  }
}
