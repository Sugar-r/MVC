package dao.idao;

import java.util.List;

import entity.Dept;

public interface IDeptDao extends IBaseDao<Dept,Integer> {
	public int insert(Dept dept) throws Exception;
	public int delete(Dept dept) throws Exception;
	public int update(Dept dept) throws Exception;
	public List<Dept> findAll() throws Exception;
	/**
	 * 
	 * @param page 分页的页数
	 * @param size 每页显示的记录数
	 * @return Dept数据集合
	 */
	public List<Dept> findByPage(int page,int size) throws Exception;
	public List<Dept> findByName(String name) throws Exception;
	public Dept findById(Integer id) throws Exception;
}
