package zarzadzanie_personelem.Entity;

import java.util.function.IntConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeForm {
    
    private static final Logger log = LoggerFactory.getLogger(EmployeeForm.class);
        
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    private String id_restauracji;
    private String imie;
    private String nazwisko;
    private String telefon;
    private String stanowisko;
    private String login;
    private String haslo;


    public String getId_restauracji() {
        return id_restauracji;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void validate(){
        
        if(!validateName()){
            valid = false;
            return;
        }
        if(!validateLastName()){
            valid = false;
            return;
        }
        if(!validateTelephone()){
            valid = false;
            return;
        }
        if(!validateLogin()){
            valid = false;
            return;
        }
        valid = true;
    }
    
    private boolean validateName(){
        if(imie.length() > 20){
            log.info("String {} has more than 20 signs", imie);
            return false;            
        }
        if(!imie.chars().allMatch(Character::isLetter)){
            log.info("Some signs of {} are not letters", imie);
            return false;            
        }
        if(!Character.isUpperCase(imie.codePointAt(0))){
            log.info("First letter of {} is not capitalized", imie);
            return false;            
        }
        
        if(!imie.substring(1).chars().allMatch(Character::isLowerCase)){
            log.info("Letters after first one of {} are capitalized", imie);
            return false;            
        }
        return true;
    }
    
    private boolean validateLastName(){
        if(nazwisko.length() > 30){
            log.info("String {} has more than 30 signs", nazwisko);
            return false;            
        }
        if(!nazwisko.chars().allMatch(Character::isLetter)){
            log.info("Some signs of {} are not letters", nazwisko);
            return false;            
        }
        return true;
    }
    
    private boolean validateTelephone(){
        if(!telefon.matches("[\\d+ ]+")){
            log.info("Telephone number {} has illegal signs", telefon);
            return false;            
        }
        String tmpPhone = telefon;
        tmpPhone = tmpPhone.replaceAll(" ", "");
        if(tmpPhone.codePointAt(0) == '+' && tmpPhone.length() != 12){
            log.info("Telephone number with plus sign, {}, does not have 9 signs", telefon);
            return false;            
        }
        Integer amountOfNumbers = tmpPhone.replaceAll("\\D", "").length();
        if(amountOfNumbers != 9 && amountOfNumbers != 11 && amountOfNumbers != 13){
            log.info("Telephone number , {}, has a different size than 9, 11 or 13", telefon);
            return false;            
        }
        return true;
    }
    
    private boolean validateLogin(){
        if(login.length() > 20){
            log.info("String {} has more than 20 signs", login);
            return false;            
        }
        if(login.length() < 5){
            log.info("String {} has less than 5 signs", login);
            return false;            
        }
        if(!login.matches("[\\p{Graph}]+")){
            log.info("Some signs of {} are not letters", login);
            return false;            
        }
        return true;
    }
}
