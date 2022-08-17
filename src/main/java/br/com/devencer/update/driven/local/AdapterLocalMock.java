package br.com.devencer.update.driven.local;

import br.com.devencer.update.core.domain.entity.Product;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AdapterLocalMock implements LocalData{
  private List<Product> products = Arrays.asList(
      new Product(1, "7891008121025","CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
      new Product(2, "7891000140307","LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
      new Product(3, "7891000064276","MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
      new Product(4, "7898461320323","ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.5")));

  public AdapterLocalMock() {}

  public AdapterLocalMock(List<Product> products) {
    this.products = products;
  }

  @Override
  public List<Product> getProductList() {
    if (products.isEmpty()) return Arrays.asList();
    return products;
  }

}
