package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, int id) {
        //获取书单价
        int price = bookShopDao.findBookPriceById(id);
        //更新书的库存
        bookShopDao.updateBookStock(id);
        //更新用户余额
        bookShopDao.updateUserAccount(username,price);
    }
}
