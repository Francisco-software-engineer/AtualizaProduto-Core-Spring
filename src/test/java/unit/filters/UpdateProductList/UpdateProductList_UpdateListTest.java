package unit.filters.UpdateProductList;

import br.com.devencer.update.core.domain.entity.Product;
import br.com.devencer.update.core.domain.filters.Filters;
import br.com.devencer.update.core.domain.filters.FiltersList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Update list accuracy test - Update list precision")
public class UpdateProductList_UpdateListTest {
    List<Product> localProductList = Arrays.asList(
            new Product(1, "7891008121025", "CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
            new Product(2, "7891000140307", "LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
            new Product(3, "7891000064276", "MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
            new Product(4, "7898461320323", "ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.5"))
    );
    List<Product> updateProductList = Arrays.asList(
            new Product(1, "7891008121025", "CAIXA DE BOMBOM GAROTO 400G", new BigDecimal("6.99")),
            new Product(2, "7891000140307", "LEITE EM PO INTEGRAL NINHO 400G", new BigDecimal("13.99")),
            new Product(3, "7891000064276", "MUCILON ARROZ NESTLE 400G", new BigDecimal("7.99")),
            new Product(4, "7898461320323", "ARROZ DOURA TIPO 1 COM 5 KG", new BigDecimal("11.3")),
            new Product(5, "9998461320323", "ARROZ", new BigDecimal("99.9"))
    );

    Filters updateListFilter = Filters.create(FiltersList.UPDATE_ITEMS_FILTER);


    @BeforeEach
    void load() {
        updateListFilter.setExternalData(updateProductList)
                .setLocalData(localProductList)
                .filter();
    }

    @Test
    @DisplayName("Success: A single result expected.")
    void updateListSizeTest() {
        assertEquals(updateListFilter.getListDTO().size(), 1);
    }

    @Test
    @DisplayName("Success: Value expected")
    void updateListValueTest() {
        assertEquals(updateListFilter.getListDTO().get(0).getBarcode(), "7898461320323");
    }

}
