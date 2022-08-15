package br.com.devencer.update.core.domain.dto;
public class Report_Log_DTO {
  private static Report_Log_DTO REPORT_LOG_DTO;
  private int numberOfProductsUpdated =0;
  private int numberOfProductsAdded = 0;

  public int getNumberOfProductsUpdated() {
    return numberOfProductsUpdated;
  }

  public void setNumberOfProductsUpdated(int numberOfProductsUpdated) {
    this.numberOfProductsUpdated = numberOfProductsUpdated;
  }

  public int getNumberOfProductsAdded() {
    return numberOfProductsAdded;
  }

  public void setNumberOfProductsAdded(int numberOfProductsAdded) {
    this.numberOfProductsAdded = numberOfProductsAdded;
  }

  public int getTotalNumberOfProducts() {
    return totalNumberOfProducts;
  }

  public void setTotalNumberOfProducts(int totalNumberOfProducts) {
    this.totalNumberOfProducts = totalNumberOfProducts;
  }

  public int getNumberOfErrorsOnAddingProducts() {
    return numberOfErrorsOnAddingProducts;
  }

  public void setNumberOfErrorsOnAddingProducts(int numberOfErrorsOnAddingProducts) {
    this.numberOfErrorsOnAddingProducts = numberOfErrorsOnAddingProducts;
  }

  public int getNumberOfErrorsOnUpdatingProducts() {
    return numberOfErrorsOnUpdatingProducts;
  }

  public void setNumberOfErrorsOnUpdatingProducts(int numberOfErrorsOnUpdatingProducts) {
    this.numberOfErrorsOnUpdatingProducts = numberOfErrorsOnUpdatingProducts;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  private int totalNumberOfProducts = 0;
  private int numberOfErrorsOnAddingProducts = 0;
  private int numberOfErrorsOnUpdatingProducts = 0;
  private String status = ""; //Success / Error

  private Report_Log_DTO(){}

  public static Report_Log_DTO getInstance() {
    if (REPORT_LOG_DTO == null) {
      REPORT_LOG_DTO = new Report_Log_DTO();
    }
    return REPORT_LOG_DTO;
  }

}
