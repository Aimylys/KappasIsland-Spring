package com.ac.kappasisland.Service;

import com.ac.kappasisland.Entities.ItemEntity;
import com.ac.kappasisland.Repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    // Points to the entity 
    @Autowired
    private ItemRepository itemRepository;
    
    // Returns all the articles it can find in the database
    public List<ItemEntity> findAll(){
        return itemRepository.findAll();
    }

    // Delete the specified article
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Save the entity to the database
    public ItemEntity saveItem(ItemEntity item) {
        return itemRepository.save(item);
    }
}