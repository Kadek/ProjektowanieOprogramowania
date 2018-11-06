package platnosci.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PaymentForm {
    
    private static final Logger log = LoggerFactory.getLogger(PaymentForm.class);
    
    private boolean valid;
    
    public boolean isValid(){
        return valid;
    }
    
    private String id_klienta;
    private String id_zamowienia;
    private String sposób_zapłaty;
    private String suma;

    public String getId_klienta() {
        return id_klienta;
    }

    public String getId_zamowienia() {
        return id_zamowienia;
    }

    public String getSposób_zapłaty() {
        return sposób_zapłaty;
    }

    public String getSuma() {
        return suma;
    }
    
    public void validate(){
        valid = false;
        for (PaymentMethods paymentMethod : PaymentMethods.values()) {
            if (paymentMethod.name().equals(sposób_zapłaty)) {
                valid = true;
            }
        }
        if(!valid){
            log.info("No such payment method as {}", sposób_zapłaty);
        }
    }
}
