package com.spring.calculator.service;

import com.spring.calculator.model.Number;
import com.spring.calculator.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private NumberRepository numberRepository;

    @Override
    public List<Number> getAll() {
        return numberRepository.findAll();
    }

    @Override
    public void save(Number number) {
        numberRepository.save(number);
    }

    @Override
    public Number getById(int id){
        return numberRepository.findById(id);
    }

    @Override
    public void update(Number number) {
        numberRepository.save(number);
    }

    @Override
    public void delete(int id) {
        numberRepository.deleteById(id);
    }





}
