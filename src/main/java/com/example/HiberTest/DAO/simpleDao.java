package com.example.HiberTest.DAO;

import com.example.HiberTest.Entities.text;
import com.example.HiberTest.Entities.textTable;

import java.util.List;

public interface simpleDao<T> {
    List<T> findAll();
}
