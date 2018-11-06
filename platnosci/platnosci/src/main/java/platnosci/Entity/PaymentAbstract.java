/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platnosci.Entity;

/**
 *
 * @author adas
 */
public abstract class PaymentAbstract {
    
    final String url;
    
    public PaymentAbstract(final String url){
        this.url = url;
    }
    
    public abstract String pay(final PaymentForm paymentForm);
    
}
