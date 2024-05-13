package com.spring.calculator.config;

import com.spring.calculator.repository.NumberRepository;
import com.spring.calculator.repository.UserRepository;
import com.spring.calculator.service.NumberService;
import com.spring.calculator.service.NumberServiceImpl;
import com.spring.calculator.service.UserService;
import com.spring.calculator.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration - zymi konfiguracijos komponenta
//viduje leidzia kurti bean per metodus su @Bean
@Configuration
public class SpringConfig {
    //Bean - tai objektai, kurie sudaro Spring aplikacijos pagrinda.
    //Paprastai tai Java klase, realizuojanti tam tikra interfeisa ir JavaBean specifikacija.
    //Bean atitinka Singleton sablona - programines irangos projektavimo schema,
    //kuri riboja klases ivykdyma vienu "vieninteliu" egzemplioriumi.
    //Tai naudinga, kai reikia tiksliai vieno objekto, norint koordinuoti veiksmus visoje sistemoje.
    private final NumberRepository numberRepository;
    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(NumberRepository numberRepository, UserRepository userRepository) {
        this.numberRepository = numberRepository;
        this.userRepository = userRepository;
    }


    @Bean
    @Qualifier("UserService")
    public UserService getUserService() {
        return new UserServiceImpl();
    }
    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService() {
        return new NumberServiceImpl();
    }

}

