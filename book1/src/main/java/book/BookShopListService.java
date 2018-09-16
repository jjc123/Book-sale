package book;

import java.util.List;

public interface BookShopListService {
    void checkout(String name, List<Integer> ids);
}
