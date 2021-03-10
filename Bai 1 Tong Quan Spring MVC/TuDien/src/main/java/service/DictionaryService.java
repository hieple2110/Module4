package service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    Map<String , String> listDictionary = new HashMap<>();

    {
        listDictionary.put("hello", "xin chao");
        listDictionary.put("one", "mot");
        listDictionary.put("two", "hai");
        listDictionary.put("five", "nam");
    }

    public String getKey(String key){
        return listDictionary.get(key);
    }
}
