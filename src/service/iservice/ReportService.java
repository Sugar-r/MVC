package service.iservice;

import java.util.List;

import entity.vo.AccountsReceivableMgVo;
import entity.vo.ActualReceiableDetailsVo;
public interface ReportService {
	/**
	 * 显示所有信息--40-应收管理 
	 * @return 实收明细报表数据--收款日期、收款金额、收款渠道、收款凭证号、经手人、备注
	 */
	List<AccountsReceivableMgVo> findAll(); 
	
	/**
	 * 模糊查询 --40-应收管理
	 * @param cons
	 * @return 返回报表数据--渠道名称、销售人、应收金额、实收金额、计划状态
	 * 
	 */
	List<String> selectChannel();
	List<String> selectSaler();
	List<AccountsReceivableMgVo> selectChannelAndSaler(String channel,String sales);
	
	/**
	 * 新增实收
	 * @param r 实收对象--渠道、销售人、收款日期、实收金额、收款凭证、备注
	 * @return String提示信息 
	 */
	String insertActualReceivable(ActualReceiableDetailsVo r);
	
	/**
	 * 显示所有渠道--40-应收管理
	 * @return 渠道名称列表
	 */
	List<String> findAllChannel(); 
	
	/**
	 * 显示所有渠道的销售人--40-应收管理
	 * @return 销售人名称列表
	 */
	List<String> selectAllSaler();
	
	/**
	 * 查看某个实收明细
	 * @param id 编号
	 * @return 实收明细对象--收款日期、收款金额、收款渠道、收款凭证号、经手人、备注
	 */
	ActualReceiableDetailsVo findById(String id);
	
	/**
	 * 修改实收
	 * @param r 实收对象--渠道、销售人、收款日期、实收金额、收款凭证、备注
	 * @return
	 */
	String updateActualReceivable(ActualReceiableDetailsVo r);
}
