package com.example.crud.services;

import com.example.crud.entity.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    List<Item> getALlItems();
    List<Item> searchItems(String text);
    List<Item> filterItems(double price);
    List<Item> filterItems2(Long stock);
    Item getItem(Long id);
    void deleteItem(Item item);
    Item saveItem(Item item);
}
