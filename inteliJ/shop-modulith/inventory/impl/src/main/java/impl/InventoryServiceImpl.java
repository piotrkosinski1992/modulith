package impl;

import api.InventoryService;
import api.dto.InventoryDTO;
import api.entity.Inventory;
import api.mapper.InventoryMapper;
import api.repository.InventoryRepository;
import impl.exceptions.NoProductWithIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public InventoryDTO getInventoryByProductId(Long productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                                                 .orElseThrow(() -> new NoProductWithIdException(productId));

        return InventoryMapper.mapToInventoryDTO(inventory);
    }

    @Override
    public void returnItemToInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findByProductId(inventoryDTO.getProductId())
                .orElseThrow(() -> new NoProductWithIdException(inventoryDTO.getProductId()));

        inventory.setAmount(inventory.getAmount() + inventoryDTO.getAmount());

        inventoryRepository.save(inventory);

    }

    @Override
    public void getItemFromInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findByProductId(inventoryDTO.getProductId())
                .orElseThrow(() -> new NoProductWithIdException(inventoryDTO.getProductId()));

        if(inventory.getAmount() >= inventoryDTO.getAmount()) {
            inventory.setAmount(inventory.getAmount() - inventoryDTO.getAmount());
        }

        inventoryRepository.save(inventory);
    }

    @Override
    public boolean isEnoughProductInInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findByProductId(inventoryDTO.getProductId())
                .orElseThrow(() -> new NoProductWithIdException(inventoryDTO.getProductId()));

        return inventory.getAmount() >= inventoryDTO.getAmount();
    }

    @Override
    public double getProductPriceById(Long productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new NoProductWithIdException(productId));
        return inventory.getPrice();
    }
}
