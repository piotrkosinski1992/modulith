package api.mapper;

import api.dto.InventoryDTO;
import api.entity.Inventory;

public class InventoryMapper {

    public static InventoryDTO mapToInventoryDTO(Inventory inventory) {
        return new InventoryDTO(inventory.getProduct().getId(),inventory.getProduct().getName(),inventory.getAmount(), inventory.getPrice());
    }
}
