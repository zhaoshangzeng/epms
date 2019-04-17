package cn.zengzhaoshang.service;

import java.util.List;

import cn.zengzhaoshang.entity.EAccount;

/**
 * 
 * @Title: EAccountService
 * @Description 登录账号 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 上午11:31:31  
 * @version v1.0
 */
public interface EAccountService {

	/**
	 * 查询所有账号
	 * @return
	 * @throws Exception
	 */
	public List<EAccount> findAccountList() throws Exception;
	
	/**
	 * 根据id查找账号
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EAccount findAccount(String id) throws Exception;
	
	/**
	 * 保存账号
	 * @param eAccount
	 * @throws Exception
	 */
	public void saveAccount(String id, EAccount eAccount) throws Exception;
	
	/**
	 * 修改账号
	 * @param eAccount
	 * @throws Exception
	 */
	public void updateAccount(String id, EAccount eAccount) throws Exception;
	
	/**
	 * 删除账号
	 * @param eAccount
	 * @throws Exception
	 */
	public void deleteAccount(String id) throws Exception;

	/**
	 * 根据用户名和密码判断是否存在，用于登陆判断
	 * @param eAccount
	 */
	public void findAccount(EAccount eAccount) throws Exception;

	/**
	 * 校验用户名是否存在，用于修改账号，避免修改不存在的账号
	 * @param eAccount
	 */
	public void findAccountByName(EAccount eAccount) throws Exception;

	/**
	 * 校验用户名是否不存在，用于添加账号，避免添加同名账号
	 * @param eAccount
	 */
	public void findAccountByNotName(EAccount eAccount) throws Exception;

	/**
	 * 根据登陆账号查找管理权限
	 * @param eAccount
	 * @return
	 */
	public Byte findPower(EAccount eAccount) throws Exception;
}
