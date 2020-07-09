package dao.idao;

import java.sql.SQLException;
import java.util.List;

import entity.User;


public interface IUserDao{
  /**
   * 实现登录功能
   * @param username 用户名
   * @param password 密码
   * @return 如果登录成功，返回值>0,否则失败
 * @throws Exception 
   */
  int login(String username,String password) throws Exception;
  /**
   * 注册功能
   * @param user （username、password、sal） 
   * @return 如果注册成功，返回值>0,否则失败
   */
  int regist(User user)throws Exception;
  /**
   * 获取用户详情
   * @param id
   * @return
 * @throws Exception 
   */
  User getUserInfo(int id) throws Exception;
  /**
   * 模糊查询
   * @param username
   * @return
   */
  List<User> findByName(String username) throws Exception;

  List<String> listUserName() throws Exception;

  int selectBalanceByName(String userF) throws  Exception;
  
  boolean transMoney(String accountFrom, String accountTo, int money);
  
  public List<User> findLike(String id, String username) throws Exception;
  
  public int delete(String t) throws Exception;
  
  public User findById(int id) throws Exception ;
  
  public List findAll() throws Exception ;
}