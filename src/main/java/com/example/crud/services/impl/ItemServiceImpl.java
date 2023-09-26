package com.example.crud.services.impl;

import com.example.crud.entity.Item;
import com.example.crud.repository.ItemRepository;
import com.example.crud.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> searchItems(String text) {
        return itemRepository.findAllByItemName(text);
    }

    @Override
    public List<Item> filterItems(double Price) {
        return itemRepository.findAllByPrice(Price);
    }

    @Override
    public List<Item> filterItems2(Long Stock) {
        return itemRepository.findAllByStock(Stock);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.getOne(id);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}
