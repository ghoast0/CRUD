package com.example.crud.repository;

import com.example.crud.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long>{
    List<Item> findAllByItemName(String ItemName);
    List<Item> findAllByPrice(double Price);
    List<Item> findAllByStock(Long Stock);
}
