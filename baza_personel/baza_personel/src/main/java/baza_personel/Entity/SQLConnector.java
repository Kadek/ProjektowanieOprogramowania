/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza_personel.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author adas
 */
public class SQLConnector {
    
    private static final Logger log = LoggerFactory.getLogger(SQLConnector.class);

    public String createEmployee(final String employeeFormJson, final String url) {
        HttpEntity<MultiValueMap<String, String>> request = getRequest(employeeFormJson); 
        
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, request, String.class); 
    }
    
    private HttpEntity<MultiValueMap<String, String>> getRequest(String formJson){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
        HashMap<String, String> map = (new Gson()).fromJson(formJson, new TypeToken<HashMap<String, String>>(){}.getType());
        MultiValueMap<String, String> multiMap = new LinkedMultiValueMap<>();
        map.entrySet().forEach((entry) -> {
            multiMap.add(entry.getKey(), entry.getValue());
        });
        
        return new HttpEntity<>(multiMap, headers);
    }
    
}
