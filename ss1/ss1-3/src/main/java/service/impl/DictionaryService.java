package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IDictionaryRepository;
import repository.impl.DictionaryRepository;
import service.IDictionaryService;

import java.util.List;
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
     private IDictionaryRepository repository = new DictionaryRepository();
    @Override
    public List<String> getEngList() {
        return repository.getEngList();
    }

    @Override
    public List<String> getVietList() {
        return repository.getVietList();
    }
}
