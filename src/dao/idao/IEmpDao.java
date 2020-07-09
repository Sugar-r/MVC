package dao.idao;

import java.util.List;

import entity.Emp;

public interface IEmpDao extends IBaseDao<Emp,Integer>{
	 /**
	  * 新增emp员工
	  * @param emp 新员工个人信息
	  * @return
	  */
	public int insert(Emp emp) throws Exception;
	public int delete(Emp emp) throws Exception;
	public int update(Emp emp) throws Exception;
	public List<Emp> findAll() throws Exception;
	/**
	 * 
	 * @param page 分页的页数
	 * @param size 每页显示的记录数
	 * @return Emp数据集合
	 */
	public List<Emp> findByPage(int page,int size) throws Exception;
	public List<Emp> findByName(String name) throws Exception;
	public Emp findById(Integer id) throws Exception;
	public List<Integer>  listNames() throws Exception ;
}