package br.com.devencer.update.core.domain.rules;

import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.entity.Rule;
import java.util.Objects;

public enum Product_Rules {
  DEFAULT {
    public Rule getRule() {
      return new Rule_Compare_BarcodeAndPrice();
    }
  },
  COMPARE_ONLYBARCODE {
    public Rule getRule() {
      return new Rule_Compare_OnlyBarcode();
    }
  };
  public abstract Rule getRule();
}

/*Rule CLASS
  Default Rule
 */
class Rule_Compare_BarcodeAndPrice implements Rule{
  @Override
  public int compareTo(Product product,Product anotherProduct) {
    //if this == anotherProduct return 0
    //if this > anotherProduct return 1
    //if this < anotherProduct return -1
    if (anotherProduct.toString() == ""){
      return -1;
    }

    int compareResult = product.getBarcode().compareTo(anotherProduct.getBarcode());

    if (compareResult == 0) {
      return product.getPrice().compareTo(anotherProduct.getPrice());
    }else{
      return compareResult;
    }
  }

  @Override
  public String toString(Product product) {
    return product.getBarcode()+product.getPrice();
  }

  @Override
  public boolean equals(Product product, Product anotherProduct) {
    if (product == anotherProduct) {
      return true;
    }
    if (anotherProduct == null || product.getClass() != anotherProduct.getClass()) {
      return false;
    }

    Product prod = (Product) anotherProduct;

    if (!Objects.equals(product.getBarcode(), prod.getBarcode())) {
      return false;
    }
    return Objects.equals(product.getPrice(), prod.getPrice());
  }

  @Override
  public int hashCode(Product product) {
    int result = product.getBarcode() != null ? product.getBarcode().hashCode() : 0;
    result = 31 * result + (product.getPrice() != null ? product.getPrice().hashCode() : 0);
    return result;
  }

}

/*Rule CLASS
  COMPARE_ONLYBARCODE
 */
class Rule_Compare_OnlyBarcode implements Rule{
  @Override
  public int compareTo(Product product,Product anotherProduct) {
    //if this == anotherProduct return 0
    //if this > anotherProduct return 1
    //if this < anotherProduct return -1
    if (anotherProduct.toString() == ""){
      return -1;
    }
    return product.getBarcode().compareTo(anotherProduct.getBarcode());

  }

  @Override
  public String toString(Product product) {
    return product.getBarcode();
  }

  @Override
  public boolean equals(Product product, Product anotherProduct) {
    if (product == anotherProduct) {
      return true;
    }
    if (anotherProduct == null || product.getClass() != anotherProduct.getClass()) {
      return false;
    }

    Product prod = (Product) anotherProduct;

    return Objects.equals(product.getBarcode(), prod.getBarcode());
  }

  @Override
  public int hashCode(Product product) {
    int result = product.getBarcode() != null ? product.getBarcode().hashCode() : 0;
    result = 31 * result;
    return result;
  }

}