package unit.filters.UpdateProductList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.error.CoreError;
import br.com.devencer.update.core.domain.filters.Filters;
import br.com.devencer.update.core.domain.filters.FiltersList;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Update Filter accuracy test - Content Equals")
public class UpdateProductList_ContentEqualsTest {
  List<Product> localProductList = Arrays.asList(
      new Product(1, "7891008121025","CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
      new Product(2, "7891000140307","LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
      new Product(3, "7891000064276","MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
      new Product(4, "7898461320323","ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.5")));
  List<Product> updateProductList = Arrays.asList(
      new Product(1, "7891008121025","CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
      new Product(2, "7891000140307","LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
      new Product(3, "7891000064276","MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
      new Product(4, "7898461320323","ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.5")));

  Filters updateListFilter = Filters.create(FiltersList.UPDATE_ITEMS_FILTER);


  @BeforeEach
  void load() {
    updateListFilter.setExternalData(updateProductList)
                    .setLocalData(localProductList);
  }

  @Test
  @DisplayName("Error: Content Equals - Nothing to update.")
  void contentEqualsTest() {

    try {
      updateListFilter.filter();
      fail("Content Equals check success...");
    } catch (CoreError e) {
      assertEquals(e.getMessage(), "Error: Empty source/update table - Nothing to update.");
      System.out.println(e.getMessage());
    }
  }
}
