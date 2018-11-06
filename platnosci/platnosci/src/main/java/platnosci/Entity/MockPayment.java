package platnosci.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class MockPayment extends PaymentAbstract{
    
    private static final Logger log = LoggerFactory.getLogger(MockPayment.class);
    
    public MockPayment(final String url){
        super(url);
    }

    @Override
    public String pay(final PaymentForm paymentForm) {
        if(paymentForm.isValid()){
            return getPaymentRedirect(paymentForm);
        }else{
            return "Invalid input";
        }
    } 
    
    private String getPaymentRedirect(final PaymentForm paymentForm){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, paymentForm, String.class);    
    }
}
