package service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Res;
import common.ResEnum;
import common.ResultEnum;
import dao.impl.UserDao;
import entity.Dept;
import entity.User;
import service.iservice.IUserService;
import util.DBUtils;

public class UserService implements IUserService{
UserDao userDao=new UserDao();
	@Override
	public String insert(User t) {
		try {
			if(userDao.insert(t)>0) return"success";
		} catch (Exception e) {
			
			e.printStackTrace();return "error";
		}
		return "error";
	}

	@Override
	public String delete(String t) {
		try {
			if(userDao.delete(t)>0) return "success:";
		} catch (Exception e) {
			
			e.printStackTrace();return "error";
		}
		return "error";
	}
	

	@Override
	public String update(User t) {
		try {
			if(userDao.update(t)>0) return"success";
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return "error";
	
	}
	public Res exist(String username) {
		Res res=null;
		try {
			int result = userDao.checkName(username);
			if(result>0) res= Res.success(ResEnum.USER_EXIST) ;
			else res= Res.success(ResEnum.USER_NOT_EXIST) ;
		} catch (Exception e) {
			
			e.printStackTrace();
			res=Res.error(ResEnum.ERROR);
			
		}
		return res;
		
	}

	@Override
	public List<User> findAll() {
		try {
			return userDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	@Override
	public List<User> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id) {
		try {
			return userDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String login(String username, String password) {
		if(username==null)
		{
			return ResultEnum.ERROR_USER_IS_NULL.getMsg();
		}
		if(password==null)
		{
			return ResultEnum.ERROR_PASSWORD_IS_NULL.getMsg();
		}
		if(password.length()<5)
		{
			return ResultEnum.ERROR_PASSWORD_lENGTH_LIMIT.getMsg();
		}
		try {
			if(userDao.checkName(username)==0)return "没有这个用户";
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return userDao.login(username, password)>0? ResultEnum.RESULT_SUCCESS.getMsg():ResultEnum.ERROR_LOGIN.getMsg();
			
		} catch (Exception e) {
		
			e.printStackTrace();
			return ResultEnum.ERROR_LOGIN_EXCEPTION.getMsg();
		}
	}

	@Override
	public String regist(User user) {
		if(user.getUserName()==null)
		{
			return "用户名不能为空";
		}
		try {
			if(userDao.checkName(user.getUserName())==1)return "用户名已存在";
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(user.getPassword()==null)
		{
			return "密码不能为空";
		}
		if(user.getPassword().length()<5)
		{
			return "密码不能小于五位";
		}
		try {
			return userDao.regist(user)>0?"注册成功":"登录失败";
			
		} catch (Exception e) {
		
			e.printStackTrace();
			return"注册异常";
		}
	}

	@Override
	public Map<String, Object> getUSerInfo(Integer id) {
		Map<String ,Object>resultMap = new HashMap<String,Object>();
		if(id==null) {
			resultMap.put("msg", "查询条件不能为空");
			resultMap.put("data",null);
			return resultMap;
		}
		User user=null;
		try {
			user=userDao.getUserInfo(id);
			resultMap.put("msg", user==null?"查询结果为空":"查询成功");
			resultMap.put("data",null);
		} catch (Exception e) {
		
			e.printStackTrace();
			resultMap.put("massage", "查询异常");
			resultMap.put("data",null);
		}
		return resultMap;
	}

	
	@Override
	public List<String> listUserName() {
		try {
			return userDao.listUserName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String recharge(String userF, String userT, int money) {
		try {
			if(userF==null)return "请选择转出账户";
			if(userT==null)return "请选择转入账户";
			if(money<=0)return "请输入正确金额";
			if(money >userDao.selectBalanceByName(userF)) return "余额不足";
			else { userDao.changeMoneyByName(userF,Math.negateExact(money));
			userDao.changeMoneyByName(userT,money);
			return "转账成功";
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return"转账异常";
		}
	}
		public String transMoney(String accountFrom, String accountTo, int money) {
			if(accountFrom==null)return "error:请选择转出账户";
			if(accountTo==null)return "error:请选择转入账户";
			if(money<=0)return "error:请输入正确金额";
			int balance;
			try {
				balance = userDao.selectBalanceByName(accountFrom);
				if (money > balance) {
					return "error:该转出账户余额不足，请更换其他账户";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "error:取账户余额失败";
			}
			boolean result = userDao.transMoney(accountFrom,accountTo,money);
			// 3-反馈
			return result?"success:转账成功":"error:转账失败";
		}
		
		public List<User> findLike(String id, String username) {
			try {
				return userDao.findLike(id, username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}


		
		
}
