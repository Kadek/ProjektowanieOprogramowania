package baza_personel.Controller;

import baza_personel.Entity.SQLConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DBController {
 
    @Autowired
    private Environment env;
    
    private static final Logger log = LoggerFactory.getLogger(DBController.class);
        
    @PostMapping("/dodajPracownika")
    public String addEmployee(
            @RequestBody String employeeForm) 
    {
        try{
            log.info("Adding employee {}", employeeForm);
            return (new SQLConnector()).createEmployee(
                    employeeForm, 
                    env.getProperty("createEmployee")
            );
        }catch(Exception e){
            return e.toString();
        }
    }
}
