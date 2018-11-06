package platnosci.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrzelewPayment extends PaymentAbstract{
    
    private static final Logger log = LoggerFactory.getLogger(PrzelewPayment.class);
    
    public PrzelewPayment(final String url){
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
