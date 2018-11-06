package platnosci.Controller;

import platnosci.Entity.PaymentVerifier;
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
public class PaymentController {
 
    @Autowired
    private Environment env;
 
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
        
    @CrossOrigin
    @PostMapping("/zaplac")
    public String pay(
            @RequestBody String paymentForm) 
    {
        try{
            log.info("Received payment form {}", paymentForm);
            return (new PaymentVerifier()).process(paymentForm, env);
        }catch(Exception e){
            return e.toString();
        }
    }
    
    @PostMapping("/potwierdz_zaplate")
    public String confirm(
            @RequestBody String token) 
    {
        try{
            log.info("Received payment confirmation for token {}", token);
            return (new PaymentVerifier()).confirm(token);
        }catch(Exception e){
            return e.toString();
        }
    }
    @PostMapping("/anuluj_zaplate")
    public String cancel(
            @RequestBody String token) 
    {
        try{
            log.info("Received payment cancel for token {}", token);
            return (new PaymentVerifier()).cancel(token);
        }catch(Exception e){
            return e.toString();
        }
    }
    
    @CrossOrigin
    @GetMapping("/pobierz_status")
    public String getStatus(
            @RequestParam String id) 
    {
        try{
            log.info("Received status request for id {}", id);
            return (new PaymentVerifier()).get_status(id);
        }catch(Exception e){
            return e.toString();
        }
    }
}
