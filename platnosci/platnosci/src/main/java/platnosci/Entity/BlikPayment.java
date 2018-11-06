package platnosci.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlikPayment extends PaymentAbstract{
    
    private static final Logger log = LoggerFactory.getLogger(BlikPayment.class);
    
    public BlikPayment(final String url){
        super(url);
    }

    @Override
    public String pay(PaymentForm paymentForm) {
        if(paymentForm.isValid()){
            return getPaymentRedirect(paymentForm);
        }else{
            return "Invalid input";
        }
    } 
    
    private String getPaymentRedirect(PaymentForm paymentForm){
        return "Not implemented";
    }
}
