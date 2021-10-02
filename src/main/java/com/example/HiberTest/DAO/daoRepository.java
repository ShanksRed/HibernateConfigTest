package com.example.HiberTest.DAO;

import com.example.HiberTest.Entities.text;
import com.example.HiberTest.Entities.textTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository("daoRepository")
public class daoRepository implements simpleDao{


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<textTable> findAll() {

        return sessionFactory.getCurrentSession().createQuery("from textTable t").list();
        //return null;
    }
}
