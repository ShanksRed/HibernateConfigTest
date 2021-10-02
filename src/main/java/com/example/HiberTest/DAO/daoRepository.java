package com.example.HiberTest.DAO;

import com.example.HiberTest.Entities.text;
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
    SessionFactory sf;


    @Override
    @Transactional
    public List<text> findAll() {
        return sf.getCurrentSession().createQuery("from text t").list();
        //return null;
    }
}
