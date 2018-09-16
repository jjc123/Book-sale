package book;

public interface BookShopDao {

    //根据id获取书价
    int findBookPriceById(int id);
    //根据id更新书的库存
    void updateBookStock(int id);
    //根据用户名和消费的金额更新用户余额
    void updateUserAccount(String name,int price);
}
