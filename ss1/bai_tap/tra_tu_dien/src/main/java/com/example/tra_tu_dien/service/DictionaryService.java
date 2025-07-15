package com.example.tra_tu_dien.service;

import com.example.tra_tu_dien.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository iDictionaryRepository;
    @Override
    public String lookupDictionary(String word) {
        return iDictionaryRepository.lookupDictionary(word);
    }
}
