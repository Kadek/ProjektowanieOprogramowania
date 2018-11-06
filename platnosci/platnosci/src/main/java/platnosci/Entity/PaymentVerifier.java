package platnosci.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import utils.EasyCache;

public class PaymentVerifier {
    
    private static final Logger log = LoggerFactory.getLogger(PaymentVerifier.class);
    
    public String process(String paymentFormJson, Environment env){
        PaymentForm paymentForm = (new Gson()).fromJson(paymentFormJson, PaymentForm.class);
        
        paymentForm.validate();
        if(!paymentForm.isValid()){
            return "Invalid input";
        }
             
        PaymentAbstract paymentProcessor;
        if(env.getProperty("config").equals("prod")){
            paymentProcessor = getPaymentProcessor(paymentForm, env);
            if(paymentProcessor == null){
                return "Could not process payment";
            }            
        }else{
            paymentProcessor = new MockPayment(env.getProperty("mockPaymentAddress"));
        }
        
        String redirectForm = paymentProcessor.pay(paymentForm);
        return processRedirectForm(redirectForm);
    }
    
    public String confirm(String token){
        EasyCache.addElement(token, "complete");
        return "Cool";
    }
    
    public String cancel(String token){
        EasyCache.addElement(token, "cancel");
        return "Cool";
    }
    
    public String get_status(String id){
        String token = EasyCache.getElement(id);
        if(token == null){
            return "Invalid id";
        }
        
        HashMap<String, String> response = new HashMap();
        response.put("status", EasyCache.getElement(token));
        return (new Gson()).toJson(response);
    }
    
    private PaymentAbstract getPaymentProcessor(PaymentForm paymentForm, Environment env){
        String paymentMethod = paymentForm.getSposób_zapłaty();
        switch(PaymentMethods.valueOf(paymentMethod)){
            case BLIK:
                return new BlikPayment(env.getProperty("blikPaymentAddress"));
            case CARD:
                return new CardPayment(env.getProperty("cardPaymentAddress"));
            case PRZELEW:
                return new PrzelewPayment(env.getProperty("przelewPaymentAddress"));
            default:
                return null;
        }
    }
    
    private String processRedirectForm(final String redirectForm){
        HashMap<String, String> redirectData = (new Gson()).fromJson(
                redirectForm,
                new TypeToken<HashMap<String, String>>(){}.getType()
        );
        EasyCache.addElement(redirectData.get("id"), redirectData.get("token"));
        EasyCache.addElement(redirectData.get("token"), "started");
        
        HashMap<String, String> response = new HashMap();
        response.put("redirectLink", redirectData.get("redirectLink"));
        return (new Gson()).toJson(response);
    }    
}
