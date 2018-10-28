package zarzadzanie_personelem.Controller;

import zarzadzanie_personelem.Entity.EmployeeCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {
 
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
        
    @CrossOrigin
    @PostMapping("/dodajPracownika")
    public String addEmployee(
            @RequestBody String employeeForm) 
    {
        try{
            log.info("Adding employee {}", employeeForm);
            return (new EmployeeCreator()).createEmployee(employeeForm);
        }catch(Exception e){
            return e.toString();
        }
    }
}
