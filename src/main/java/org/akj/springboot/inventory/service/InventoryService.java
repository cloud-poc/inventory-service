package org.akj.springboot.inventory.service;

import java.util.List;
import java.util.Optional;

import org.akj.springboot.inventory.entity.Inventory;
import org.akj.springboot.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository = null;

	public InventoryRepository getInventoryRepository() {
		return inventoryRepository;
	}

	public Optional<Inventory> findByProductCode(String productCode) {
		return inventoryRepository.findByProductCode(productCode);
	}

	public List<Inventory> findAll() {
		return inventoryRepository.findAll();
	}
	
	public Inventory add(Inventory inventory){
		return inventoryRepository.save(inventory);
	}

}