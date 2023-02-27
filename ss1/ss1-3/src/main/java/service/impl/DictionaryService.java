package service.impl;

import repository.IDictionaryRepository;
import repository.impl.DictionaryRepository;
import service.IDictionaryService;

import java.util.List;

public class DictionaryService implements IDictionaryService {
    IDictionaryRepository repository = new DictionaryRepository();
    @Override
    public List<String> getEngList() {
        return repository.getEngList();
    }

    @Override
    public List<String> getVietList() {
        return repository.getVietList();
    }
}
