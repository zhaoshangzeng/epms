package cn.zengzhaoshang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.EAccountMapper;
import cn.zengzhaoshang.entity.EAccount;
import cn.zengzhaoshang.entity.EAccountExample;
import cn.zengzhaoshang.entity.EAccountExample.Criteria;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EAccountService;

/**
 * 
 * @Title: EAccountServiceImpl
 * @Description 登录账号 业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午12:10:06  
 * @version v1.0
 */
public class EAccountServiceImpl implements EAccountService {

	@Autowired
	private EAccountMapper eAccountMapper;
	
	/**
	 * 查询所有账号
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EAccount> findAccountList() throws Exception {
		return eAccountMapper.selectByExample(new EAccountExample());
	}

	/**
	 * 根据id查找账号
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public EAccount findAccount(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		return eAccountMapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存账号
	 * @param eAccount
	 * @throws Exception
	 */
	@Override
	public void saveAccount(String id, EAccount eAccount) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eAccount.setId(id);
		int value = eAccountMapper.insertSelective(eAccount);
		if(value == 0) {
			throw new CustomException("保存失败！请重新提交！");
		}
	}

	/**
	 * 修改账号
	 * @param eAccount
	 * @throws Exception
	 */
	@Override
	public void updateAccount(String id, EAccount eAccount) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eAccount.setId(id);
		int value = eAccountMapper.updateByPrimaryKeySelective(eAccount);
		if(value == 0) {
			throw new CustomException("更新失败！其他管理员刚刚进行了更新，您现在获取的不是最新数据！请从左侧导航重新进入，重新更新！");
		}
	}

	/**
	 * 删除账号
	 * @param eAccount
	 * @throws Exception
	 */
	@Override
	public void deleteAccount(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		int value = eAccountMapper.deleteByPrimaryKey(id);
		if(value == 0) {
			throw new CustomException("删除失败！请重新删除！");
		}
	}

	/**
	 * 根据用户名和密码判断是否存在，用于登陆判断
	 * @param eAccount
	 */
	@Override
	public void findAccount(EAccount eAccount) throws Exception {
		//查找是否存在该登录名，找不到则抛异常
		findAccountName(eAccount);
		//查找是否该用户的密码是否正确，找不到则抛异常
		findAccountPassword(eAccount);
	}

	/**
	 * 查找是否存在该登录名
	 * @param eAccount
	 * @throws CustomException
	 */
	public void findAccountName(EAccount eAccount) throws Exception {
		EAccountExample eAccountExample = new EAccountExample();
		Criteria criteria = eAccountExample.createCriteria();
		criteria.andNameEqualTo(eAccount.getName());
		List<EAccount> list = eAccountMapper.selectByExample(eAccountExample);
		if(list.size() == 0) {
			throw new CustomException("不存在该账户!");
		}
	}
	
	/**
	 * 查找是否该用户的密码是否正确
	 * @param eAccount
	 * @throws CustomException
	 */
	public void findAccountPassword(EAccount eAccount) throws Exception {
		EAccountExample eAccountExample = new EAccountExample();
		Criteria criteria = eAccountExample.createCriteria();
		criteria.andNameEqualTo(eAccount.getName());
		criteria.andPasswordEqualTo(eAccount.getPassword());
		List<EAccount> list = eAccountMapper.selectByExample(eAccountExample);
		if(list.size() == 0) {
			throw new CustomException("该账户的密码不正确!");
		}
	}

	/**
	 * 校验用户名是否存在，用于修改账号，避免修改不存在的账号
	 * @param eAccount
	 */
	@Override
	public void findAccountByName(EAccount eAccount) throws Exception{
		//查找是否存在该登录名，找不到则抛异常
		findAccountName(eAccount);
	}

	/**
	 * 校验用户名是否不存在，用于添加账号，避免添加同名账号
	 * @param eAccount
	 */
	@Override
	public void findAccountByNotName(EAccount eAccount) throws Exception{
		EAccountExample eAccountExample = new EAccountExample();
		Criteria criteria = eAccountExample.createCriteria();
		criteria.andNameEqualTo(eAccount.getName());
		List<EAccount> list = eAccountMapper.selectByExample(eAccountExample);
		if(list.size() != 0) {
			throw new CustomException("存在该账户，请更换其他账号名!");
		}
	}

	/**
	 * 根据登陆账号查找管理权限
	 * @param eAccount
	 * @return
	 */
	@Override
	public Byte findPower(EAccount eAccount) throws Exception {
		EAccountExample eAccountExample = new EAccountExample();
		Criteria criteria = eAccountExample.createCriteria();
		criteria.andNameEqualTo(eAccount.getName());
		List<EAccount> list = eAccountMapper.selectByExample(eAccountExample);
		return list.get(0).getPower();
	}

}
