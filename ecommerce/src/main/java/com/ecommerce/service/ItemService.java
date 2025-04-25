package com.ecommerce.service;
import com.ecommerce.entity.Item;
import com.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {
    
    private final ItemRepository itemRepository;
    
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    // Create
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }
    
    // Read
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }
    
    public List<Item> getItemsByNameContaining(String name) {
        return itemRepository.findByNameContaining(name);
    }
    
    public List<Item> getItemsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return itemRepository.findByPriceRange(minPrice, maxPrice);
    }
    
    // Update
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }
    
    // Delete
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}