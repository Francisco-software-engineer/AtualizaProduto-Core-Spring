package br.com.devencer.update.driven.sourceupdate;

import br.com.devencer.update.core.domain.entity.Product;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AdapterUpdateMock implements UpdateData{
  private List<Product> products = Arrays.asList(
      new Product(1, "7891008121025","CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("2.99")),
      new Product(2, "7891000140307","LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("16.99")),
      new Product(3, "7891000064276","MUCILON ARROZ NESTLE 400G", new BigDecimal("9.99")),
      new Product(4, "7896105177050","BISCOITO SALT CRACKER AGUIA 360G", new BigDecimal("4.39")),
      new Product(5, "7896213000448","BISCOITO VITARELLA CREAM CRACKER TRADICIONAL 400G", new BigDecimal(
          "3.99")),
      new Product(6, "7898461320323","ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.5")));

  public AdapterUpdateMock() {}

  public AdapterUpdateMock(List<Product> products) {
    this.products = products;
  }

  @Override
  public List<Product> getProductList() {
    if (products.isEmpty()) return Arrays.asList();
    return products;
  }

}
