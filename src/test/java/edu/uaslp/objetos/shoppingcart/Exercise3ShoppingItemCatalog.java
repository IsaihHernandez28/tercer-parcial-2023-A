package edu.uaslp.objetos.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3ShoppingItemCatalog {
    @Test
    public void givenAValidCode_whenGetShoppingItem_thenShoppingItemIsReturned(){
        // Given
        int validCode = 12345;
        ShoppingItemCatalog catalog = new ShoppingItemCatalog();
        ShoppingItem expectedItem = new ShoppingItem(validCode, "Valid Item", 10.0);

        // When
        ShoppingItem shoppingItem = catalog.getItem(validCode);

        // Then
        Assert.assertNotNull(shoppingItem);
        Assert.assertEquals(shoppingItem.getCode(), expectedItem.getCode());
        Assert.assertEquals(shoppingItem.getDescription(), expectedItem.getDescription());
        Assert.assertEquals(shoppingItem.getUnitCostInPesos(), expectedItem.getUnitCostInPesos());
    }

    @Test
    public void givenANotValidCode_whenGetShoppingItem_thenNullIsReturned(){
        // Given
        int invalidCode = 67890;
        ShoppingItemCatalog catalog = new ShoppingItemCatalog();

        // When
        ShoppingItem shoppingItem = catalog.getItem(invalidCode);

        // Then
        Assert.assertNull(shoppingItem);
    }
}
