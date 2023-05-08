package edu.uaslp.objetos.shoppingcart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final ShoppingItemCatalog shoppingItemCatalog;
    private final Map<String, Integer> items = new HashMap<>();

    public ShoppingCart(ShoppingItemCatalog shoppingItemCatalog) {
        this.shoppingItemCatalog = shoppingItemCatalog;
    }

    public void add(String code) {
        if (!items.containsKey(code)) {
            items.put(code, 1);
        } else {
            items.put(code, items.get(code) + 1);
        }
    }

    public int getTotalCostInCents() {
        int totalCost = 0;
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            String code = item.getKey();
            int quantity = item.getValue();
            ShoppingItem shoppingItem = shoppingItemCatalog.getItem(code);
            totalCost += shoppingItem.getUnitCostInCents() * quantity;
        }
        return totalCost;
    }

    public int getDistinctItemsCount() {
        return items.keySet().size();
    }

    public int getTotalItemsCount() {
        int totalItemsCount = 0;
        for (int quantity : items.values()) {
            totalItemsCount += quantity;
        }
        return totalItemsCount;
    }

    public List<ShoppingItem> getItems() {
        List<ShoppingItem> shoppingItems = new ArrayList<>();
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            String code = item.getKey();
            int quantity = item.getValue();
            ShoppingItem shoppingItem = shoppingItemCatalog.getItem(code);
            for (int i = 0; i < quantity; i++) {
                shoppingItems.add(shoppingItem);
            }
        }
        return shoppingItems;
    }

    public Collection<ShoppingItem> getDistinctItems() {
        Collection<ShoppingItem> shoppingItems = new ArrayList<>();
        for (String code : items.keySet()) {
            shoppingItems.add(shoppingItemCatalog.getItem(code));
        }
        return shoppingItems;
    }
}
