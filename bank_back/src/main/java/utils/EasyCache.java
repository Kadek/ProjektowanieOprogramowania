
package utils;

import java.util.HashMap;

public class EasyCache {
    
    private static HashMap<String, String> cache = new HashMap();
    
    public static void addElement(String key, String value){
        cache.put(key, value);
    }
    
    public static String getElement(String key){
        return cache.get(key);
    }
    
}
