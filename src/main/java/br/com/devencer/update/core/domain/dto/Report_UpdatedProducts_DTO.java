package br.com.devencer.update.core.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Report_UpdatedProducts_DTO implements Serializable {
  private static Report_UpdatedProducts_DTO REPORT_UPDATEDPRODUCTS_DTO;

  private static final long serialVersionUID = 1L;
  private List<Product_DTO> listOfProductsUpdated = new ArrayList<>();

  public List<Product_DTO> getListOfProductsUpdated() {
      return listOfProductsUpdated;
  }

  public void setListOfProductsUpdated(List<Product_DTO> productList) {
    listOfProductsUpdated = productList;
    Report_Log_DTO.getInstance().setNumberOfProductsUpdated(listOfProductsUpdated.size());
  }
  private Report_UpdatedProducts_DTO(){}
  public static Report_UpdatedProducts_DTO getInstance() {
    if (REPORT_UPDATEDPRODUCTS_DTO == null) {
      REPORT_UPDATEDPRODUCTS_DTO = new Report_UpdatedProducts_DTO();
    }
    return REPORT_UPDATEDPRODUCTS_DTO;
  }
}
