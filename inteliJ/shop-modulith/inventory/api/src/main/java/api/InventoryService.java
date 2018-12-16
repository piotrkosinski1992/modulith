package api;

import api.dto.InventoryDTO;
import api.entity.Inventory;

public interface InventoryService {

    InventoryDTO getInventoryByProductId(Long productId);

    void returnItemToInventory(InventoryDTO inventoryDTO);

    void getItemFromInventory(InventoryDTO inventoryDTO);

    boolean isEnoughProductInInventory(InventoryDTO inventoryDTO);

    double getProductPriceById(Long productId);

    int getInventoryAmountByProductId(Long productId);
}
