package com.example.crud.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.crud.entity.Item;
import com.example.crud.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/getAllItems")
    @ResponseBody
    public List<Item> getItemsTable(){
        List <Item> items = itemService.getAllItems();
        return items;
    }

    @PostMapping("/addNewItem")
    @ResponseBody
    public String addNewItem(@RequestParam(name = "itemName") String itemName,
                             @RequestParam(name = "price") String price,
                             @RequestParam(name = "stock") String stock){
        try{
            itemService.addItem(new Item(null, itemName, Double.parseDouble(price), Long.parseLong(stock)));
            return "New item added!";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Something went wrong!";
        }
    }

    @DeleteMapping("/deleteItem/{id}")
    @ResponseBody
    public String deleteItem(@PathVariable(name = "id") Long id){
        Item item = new Item();
        try{
            item = itemService.getItem(id);
            itemService.deleteItem(item);
            return "Item deleted!";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Something went wrong!";
        }
    }

    @PostMapping("/editItem")
    @ResponseBody
    public String addNewItem(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "itemName") String itemName,
                            @RequestParam(name = "price") String price,
                            @RequestParam(name = "stock") String stock){
        try{
            itemService.saveItem(new Item(id, itemName, Double.parseDouble(price), Long.parseLong(stock)));
            return "The item has been updated!";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Something went wrong!";
        }
    }

    @GetMapping("/searchItems/{text}")
    @ResponseBody
    public List<Item> getSearchItems(@PathVariable(name = "text")String text){
        List<Item> items = itemService.searchItems(text);
        return items;
    }

    @GetMapping("/filterByPrice/{price}")
    @ResponseBody
    public List<Item> getFilteredCars2(@PathVariable(name = "price")String price){
        List<Item> items = itemService.filterItems(Double.parseDouble(price));
        return items;
    }

    @GetMapping("/filterByYear/{stock}")
    @ResponseBody
    public List<Item> getFilteredCars(@PathVariable(name = "stock")String stock){
        List<Item> items = itemService.filterItems2(Long.parseLong(stock));
        return items;
    }
}
