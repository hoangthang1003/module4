package repository.impl;

import org.springframework.stereotype.Repository;
import repository.IDictionaryRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static final List<String> englishList = new ArrayList<>();
    private static final List<String> vietnameseList = new ArrayList<>();


    static {

        englishList.add("Blue");
        englishList.add("Yellow");
        englishList.add("Red");
        englishList.add("Green");
        englishList.add("Brown");


        vietnameseList.add("Màu xanh biển");
        vietnameseList.add("Màu vàng");
        vietnameseList.add("Màu đỏ");
        vietnameseList.add("Màu xanh lá");
        vietnameseList.add("Màu nâu");
    }

    @Override
    public List<String> getEngList() {
        return englishList;
    }

    @Override
    public List<String> getVietList() {
        return vietnameseList;
    }
}
