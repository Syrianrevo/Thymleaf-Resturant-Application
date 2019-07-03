package com.syrianrevo.thymeleafkafkaproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.syrianrevo.thymeleafkafkaproject.domain.Entry;

import java.util.List;


/**
 * Created by Ammar Mohrat.
 */
public interface EntryRepository extends CrudRepository<Entry, Long> {
    List<Entry> findAll();
    List<Entry> findByItemName(String itemName);
}
