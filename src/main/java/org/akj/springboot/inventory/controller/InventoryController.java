package org.akj.springboot.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.akj.springboot.inventory.entity.Inventory;
import org.akj.springboot.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private final InventoryService inventoryService;

	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("{productCode}")
	public ResponseEntity<Inventory> findInventoryByProductCode(@PathVariable("productCode") String productCode) {
		Optional<Inventory> inventoryItem = inventoryService.findByProductCode(productCode);
		if (inventoryItem.isPresent()) {
			return new ResponseEntity(inventoryItem, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Inventory> getInventory() {
		return inventoryService.findAll();
	}

	@PostMapping
	public Inventory insert(@RequestBody Inventory inventory) {
		return inventoryService.add(inventory);
	}

}