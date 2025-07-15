package com.example.tra_tu_dien.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("dictionary", "từ điển");
        dictionary.put("look", "nhìn");
        dictionary.put("cat", "con mèo");
        dictionary.put("good", "tốt");
        dictionary.put("bad", "xấu");
    }


    @Override
    public String lookupDictionary(String word) {
        return dictionary.get(word);
    }
}
