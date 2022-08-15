package br.com.devencer.update.core.domain.dto;

import java.math.BigDecimal;

//Default DTO for Guest
public class Product_DTO {
  private int id;
  private String barcode;
  private String description;
  private BigDecimal price;

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
