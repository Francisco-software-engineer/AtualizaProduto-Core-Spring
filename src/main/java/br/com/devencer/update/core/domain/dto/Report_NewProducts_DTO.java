package br.com.devencer.update.core.domain.dto;

public class Report_NewProducts_DTO {
  private static Report_NewProducts_DTO REPORT_NEWPRODUCTS_PRODUCTS_DTO;
  private Report_NewProducts_DTO(){}
  public static Report_NewProducts_DTO getInstance() {
    if (REPORT_NEWPRODUCTS_PRODUCTS_DTO == null) {
      REPORT_NEWPRODUCTS_PRODUCTS_DTO = new Report_NewProducts_DTO();
    }
    return REPORT_NEWPRODUCTS_PRODUCTS_DTO;
  }
}
