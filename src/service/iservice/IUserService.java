package service.iservice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import entity.User;

public interface IUserService extends IBaseService<User,Integer>{
String login(String username,String password);
String regist (User user);
Map<String,Object> getUSerInfo(Integer id);
List<String> listUserName();

String recharge(String userF, String userT, int money);

public String transMoney(String accountFrom, String accountTo, int money);

public List<User> findLike(String id, String username) ;

}
