package org.akj.springboot.inventory.repository;

import java.util.Optional;

import org.akj.springboot.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
	Optional<Inventory> findByProductCode(String productCode);
}