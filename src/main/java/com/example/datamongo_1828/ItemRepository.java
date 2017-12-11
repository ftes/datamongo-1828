package com.example.datamongo_1828;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, Integer> {
    /**
     * Does not work as expected.
     */
    @Query("{ $or : [ { $where: '?0 == null' } , { tags: ?0 } ] }")
    List<Item> findByOptionalTag(String tag);

    @Query("{ $or : [ { $where: '?0 == null' } , { id: ?0 } ] }")
    List<Item> findByOptionalId(Integer id);
    List<Item> findByTags(String tag);
}
