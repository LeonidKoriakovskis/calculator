package com.spring.calculator.service;

import com.spring.calculator.model.Number;
import com.spring.calculator.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service - servisu sluoksnis biznio logikai
//Po serviso sluoksniu kreipiames i DAO
@Service
public class NumberServiceImpl implements NumberService{
    //autowire - naudojamas automatinei priklausomybiu injekcijai
    //kad panaudoti @Autowired anotacija, reikia pirmiausiai tureti apsirasius @Bean @Configuration kalseje
    @Autowired
    //@Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai bean susieti priklausomybe.
    //Jeigu @Configuration klaseje yra daugiau negu vienas bean, @Qualifier anotacija yra privaloma,
    //kitu atvieju metama klaida:
    //'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    //or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")
    private NumberDAO numberDAO;

    @Override
    public List<Number> getAll() {
        return numberDAO.findEntities();
    }

    @Override
    public void save(Number number) {
        numberDAO.insertEntity(number);
    }

    @Override
    public Number getById(int id){
        return numberDAO.findEntityByID(id);
    }

    @Override
    public void update(Number number) {
        numberDAO.updateEntity(number);
    }

    @Override
    public void delete(int id) {
        numberDAO.removeEntityByID(id);
    }





}
