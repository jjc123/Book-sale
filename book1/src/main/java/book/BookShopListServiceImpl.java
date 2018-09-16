package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookShopListService")
public class BookShopListServiceImpl implements BookShopListService{

    @Autowired
    private BookShopService bookShopService;

    @Transactional()
    @Override
    public void checkout(String name, List<Integer> ids) {
        for(Integer one:ids){
            bookShopService.purchase(name,one);
        }
    }
}
