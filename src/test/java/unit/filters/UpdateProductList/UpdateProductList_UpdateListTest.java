package unit.filters.UpdateProductList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.devencer.update.core.domain.dto.Report_Log_DTO;
import br.com.devencer.update.core.domain.dto.Report_UpdatedProducts_DTO;
import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.filters.UpdateProductList;
import br.com.devencer.update.driven.local.AdapterLocalMock;
import br.com.devencer.update.driven.local.LocalData;
import br.com.devencer.update.driven.sourceupdate.AdapterUpdateMock;
import br.com.devencer.update.driven.sourceupdate.UpdateData;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Update list accuracy test - Update list precision")
public class UpdateProductList_UpdateListTest {
  List<Product> localProductList = Arrays.asList(
      new Product(1, "7891008121025","CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
      new Product(2, "7891000140307","LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
      new Product(3, "7891000064276","MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
      new Product(4, "7898461320323","ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.5"))
  );
  List<Product> updateProductList = Arrays.asList(
      new Product(1, "7891008121025","CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
      new Product(2, "7891000140307","LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
      new Product(3, "7891000064276","MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
      new Product(4, "7898461320323","ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.3")),
      new Product(5, "9998461320323","ARROZ", new BigDecimal("99.9"))
      );

  LocalData localData;
  UpdateData updateData;
  UpdateProductList updateListFilter;
  int updateItemNumber;


  @BeforeEach
  void load() {
    localData = new AdapterLocalMock(localProductList);
    updateData = new AdapterUpdateMock(updateProductList);
    updateListFilter = new UpdateProductList(updateData, localData);
    updateListFilter.applyFilter();
  }

  @Test
  @DisplayName("Success: One result expected.")
  void updateListSizeTest() {
    assertEquals(Report_Log_DTO.getInstance().getNumberOfProductsUpdated(), 1);
  }

  @Test
  @DisplayName("Success: Value expected")
  void updateListValueTest() {
    assertEquals(Report_UpdatedProducts_DTO.getInstance().getListOfProductsUpdated().get(0).getBarcode(), "7898461320323");
  }
}
