package com.itransition.repository;

import com.itransition.entity.CollectionDB;
import com.itransition.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository
        extends JpaRepository<CollectionDB, Long>
{

    List<CollectionDB> findAll();
    List<CollectionDB> findByUser_id(Long id);
    void deleteById(Integer id);


}
