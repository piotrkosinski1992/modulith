package api;

import api.dto.InventoryDTO;

public interface InventoryService {

    InventoryDTO getInventoryByProductId(Long productId);

    void returnItemToInventory(InventoryDTO inventoryDTO);

    void getItemFromInventory(InventoryDTO inventoryDTO);

    boolean isEnoughProductInInventory(InventoryDTO inventoryDTO);

    double getProductPriceById(Long productId);
}
