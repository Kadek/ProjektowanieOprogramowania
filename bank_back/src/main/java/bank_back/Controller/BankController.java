package bank_back.Controller;

import bank_back.Entity.BankConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BankController {
 
    @Autowired
    private Environment env;
 
    private static final Logger log = LoggerFactory.getLogger(BankController.class);
        
    @CrossOrigin
    @GetMapping("/success")
    public String success(
            @RequestParam String id) 
    {
        try{
            log.info("Received success request from id {}", id);
            return (new BankConnector()).success(id, env);
        }catch(Exception e){
            return e.toString();
        }
    }
        
    @CrossOrigin
    @GetMapping("/failure")
    public String failure(
            @RequestParam String id) 
    {
        try{
            log.info("Received failure request from id {}", id);
            return (new BankConnector()).failure(id, env);
        }catch(Exception e){
            return e.toString();
        }
    }
    
    @PostMapping("/startPayment")
    public String startPayment(
            @RequestBody String paymentJson) 
    {
        try{
            log.info("Received start payment request for payment {}", paymentJson);
            return (new BankConnector()).startPayment(paymentJson, env);
        }catch(Exception e){
            return e.toString();
        }
    }
}
