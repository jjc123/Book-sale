package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*
    因为不是映射一整行  所以不需要RowMapper
     */
    @Override
    public int findBookPriceById(int id) {
        String sql = "SELECT price FROM book_price WHERE id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,1);
    }

    @Override
    public void updateBookStock(int id) {
        //验证库存是否足够，因为mysql不会帮我们验证约束
        String sqlStock = "SELECT stock FROM book_stock WHERE id =?";
        int stock =jdbcTemplate.queryForObject(sqlStock,Integer.class,id);
        if(stock ==0){
            throw new BookStockException("库存不足");
        }
        String sql ="UPDATE book_stock SET stock = stock-1 WHERE id =?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateUserAccount(String name, int price) {
        //验证账户余额
        String sqlAccount = "SELECT money FROM account WHERE name = ?";
        int money =jdbcTemplate.queryForObject(sqlAccount,Integer.class,name);
        if(money <price){
            throw new UserAccountException("余额不足");
        }
        String sql = "UPDATE account SET money = money - ? WHERE name= ?";
        jdbcTemplate.update(sql,price,name);
    }
}
