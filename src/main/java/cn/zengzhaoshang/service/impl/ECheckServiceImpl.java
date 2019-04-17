package cn.zengzhaoshang.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.ECheckMapper;
import cn.zengzhaoshang.dao.ECheckQueryMapper;
import cn.zengzhaoshang.dao.EDepartMapper;
import cn.zengzhaoshang.dao.ERuleMapper;
import cn.zengzhaoshang.dao.EStaffMapper;
import cn.zengzhaoshang.dto.ECheckCount;
import cn.zengzhaoshang.dto.ECheckCustom;
import cn.zengzhaoshang.dto.ECheckQueryVo;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.ECheck;
import cn.zengzhaoshang.entity.ECheckExample;
import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.entity.EDepartExample;
import cn.zengzhaoshang.entity.ERule;
import cn.zengzhaoshang.entity.ERuleExample;
import cn.zengzhaoshang.entity.EStaff;
import cn.zengzhaoshang.entity.EStaffExample;
import cn.zengzhaoshang.entity.EStaffExample.Criteria;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.ECheckService;

/**
 * 
 * @Title: ECheckServiceImpl
 * @Description 员工考勤 业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午3:46:54
 * @version v1.0
 */
public class ECheckServiceImpl implements ECheckService {

	@Autowired
	private ECheckMapper eCheckMapper;

	@Autowired
	private ECheckQueryMapper eCheckQueryMapper;

	@Autowired
	private EStaffMapper eStaffMapper;

	@Autowired
	private ERuleMapper eRuleMapper;

	@Autowired
	private EDepartMapper eDepartMapper;

	/**
	 * 查询上个月所有考勤信息，并计算是否达标
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<ECheckCustom> findCheckListLast(ECheckQueryVo eCheckQueryVo) throws Exception {
		// 获取上个月的日期
		Date lastMonth = getLastMonth(); // 方法见下方
		// 获得上一月的全部考勤信息，但缺达标信息
		eCheckQueryVo.setMonth(lastMonth);
		List<ECheckCustom> checkList = eCheckQueryMapper.selectByMonthAndPage(eCheckQueryVo);
		if (checkList.size() == 0) {
			throw new CustomException("上个月没有任何考勤，请填写上个月的考勤信息！");
		}
		// 给所有考勤设置达标情况
		setListWithDaBiao(checkList); // 方法见下方
		// 将考勤信息存到分页类中
		PageBean<ECheckCustom> pageBean = eCheckQueryVo.getPageBean();
		pageBean.setBeanList(checkList);
		// 查找总记录数
		long count = eCheckMapper.countByExample(new ECheckExample());
		// 将总记录数存到分页类中
		pageBean.setTr((int) count);
		return pageBean;
	}

	/**
	 * 给所有考勤设置达标情况
	 * 
	 * @param checkList
	 */
	public void setListWithDaBiao(List<ECheckCustom> checkList) {
		// 获得达标规则
		ERule eRule = eRuleMapper.selectByExample(new ERuleExample()).get(0);
		// 遍历每个人的考勤信息，分别进行计算达标情况
		for (ECheckCustom eCheckCustom : checkList) {
			// 根据达标规则，设置达标情况
			calIsDaBiao(eRule, eCheckCustom); // 方法见下方
		}
	}

	/**
	 * 根据达标规则，计算是否达标 //这里是比对和算出谁达标 的核心代码
	 * 
	 * @param eRule
	 * @param eCheckCustom
	 */
	public void calIsDaBiao(ERule eRule, ECheckCustom eCheckCustom) {
		eCheckCustom.setIsDaBiao(1);// 先默认设置为达标了
		if (eCheckCustom.getLateNum() > eRule.getMaxLate()) {
			eCheckCustom.setIsDaBiao(0);// 超出达标规则，则设置为不达标
		}
		if (eCheckCustom.getEarlyNum() > eRule.getMaxEarly()) {
			eCheckCustom.setIsDaBiao(0);
		}
		if (eCheckCustom.getAbsenceNum() > eRule.getMaxAbsence()) {
			eCheckCustom.setIsDaBiao(0);
		}
		if (eCheckCustom.getLeaveNum() > eRule.getMaxLeave()) {
			eCheckCustom.setIsDaBiao(0);
		}
	}

	/**
	 * 获取上个月的日期
	 * 
	 * @return
	 * @throws ParseException
	 */
	public Date getLastMonth() throws ParseException {
		Date d = new Date();
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(d); // 设置为当前时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
		d = calendar.getTime(); // 转为Date类型

		String month = new SimpleDateFormat("yyyy-MM").format(d); // 清空具体日期
		return new SimpleDateFormat("yyyy-MM").parse(month); // 模拟表单输入时的情况
	}

	/**
	 * 查询上个月所有考勤信息，并进行统计
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public ECheckCount findCheckCount() throws Exception {
		// 获取上个月的日期
		Date lastMonth = getLastMonth();
		// 获得上个月所有考勤信息
		List<ECheckCustom> checkList = eCheckQueryMapper.selectByMonth(lastMonth);
		if (checkList.size() == 0) {
			throw new CustomException("上个月没有任何考勤，无法统计！");
		}

		// 给该月所有考勤设置达标情况
		setListWithDaBiao(checkList);

		// 根据考勤信息和日期，获得考勤统计类
		ECheckCount eCheckCount = getECheckCount(checkList, lastMonth);

		return eCheckCount;
	}

	/**
	 * 查询某个月所有考勤信息，并进行统计
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public ECheckCount findCheckCount(Date month) throws Exception {

		List<ECheckCustom> checkList = eCheckQueryMapper.selectByMonth(month);
		if (checkList.size() == 0) {
			throw new CustomException("该月没有任何考勤，无法统计！");
		}

		// 给该月所有考勤设置达标情况
		setListWithDaBiao(checkList);

		// 根据考勤信息和日期，获得考勤统计类
		ECheckCount eCheckCount = getECheckCount(checkList, month);

		return eCheckCount;
	}

	/**
	 * 根据考勤信息和日期，获得考勤统计类
	 * 
	 * @param checkList
	 * @param month
	 * @return
	 */
	public ECheckCount getECheckCount(List<ECheckCustom> checkList, Date month) {
		ECheckCount eCheckCount = new ECheckCount(); // 考勤统计类

		double allCheckNum = checkList.size(); // 获取考勤总人数
		double calIsDaBiao = calIsDaBiao(checkList); // 获取达标总人数
		double calNotIsDaBiao = allCheckNum - calIsDaBiao; // 获取未达标总人数
		double ratio = (double) Math.round(calIsDaBiao / allCheckNum * 10000) / 10000; // 得到总达标比例，保留了后4位小数

		String ratioStr = ratio * 100 + "%"; // 将达标比例转为字符串，用于页面显示
		Map<String, String> deptRatioMap = getDeptRatioMap(checkList); // 得到未达标人员所在部门的集合

		eCheckCount.setCheckDate(month);
		eCheckCount.setStaffNum((int) allCheckNum);
		eCheckCount.setStaffDaBiaoNum((int) calIsDaBiao);
		eCheckCount.setStaffNotDaBiaoNum((int) calNotIsDaBiao);
		eCheckCount.setRatio(ratioStr);
		eCheckCount.setDeptRatio(deptRatioMap);
		return eCheckCount;
	}

	/**
	 * 获取未达标人员所在部门的集合
	 * 
	 * @param checkList
	 * @return
	 */
	public Map<String, String> getDeptRatioMap(List<ECheckCustom> checkList) {
		Map<String, String> map = new HashMap<String, String>(); // 用于存储未达标人员所在部门的集合
		List<EDepart> deptList = eDepartMapper.selectByExample(new EDepartExample()); // 获取所有部门信息
		for (EDepart eDepart : deptList) { // 遍历每个部门
			String deptName = eDepart.getDeptName(); // 部门名称
			int notDaBiaoNum = 0; // 记录未达标人数
			for (ECheckCustom eCheckCustom : checkList) { // 在每个部门中遍历所有考勤信息
				if (eCheckCustom.getDeptName().equals(deptName)) { // 匹配考勤信息的部门名称
					if (eCheckCustom.getIsDaBiao() == 0) { // 如果在该部门下，有未达标，则下面变量开始累加
						++notDaBiaoNum;
					}
				}
			}
			if (notDaBiaoNum != 0) { // 当存在未达标人数，则存到集合中
				map.put(deptName, notDaBiaoNum + ""); // 存储到map //记录该部门，和累加结果
			}
		}

		return map;
	}

	/**
	 * 获取达标人数
	 * 
	 * @param list
	 */
	public int calIsDaBiao(List<ECheckCustom> list) {
		int isDaBiao = 0;
		for (ECheckCustom eCheckCustom : list) {
			if (eCheckCustom.getIsDaBiao() == 1) {
				++isDaBiao;
			}
		}
		return isDaBiao;
	}

	/**
	 * 根据id查找考勤信息，并计算是否达标
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ECheckCustom findCheck(String id) throws Exception {
		if (id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		ECheckCustom eCheckCustom = eCheckQueryMapper.selectByPrimaryKey(id);
		// 获得达标规则
		ERule eRule = eRuleMapper.selectByExample(new ERuleExample()).get(0);
		// 根据达标规则，设置达标情况
		calIsDaBiao(eRule, eCheckCustom);
		return eCheckCustom;
	}

	/**
	 * 根据多条件查找考勤信息
	 * 
	 * @param checkCustom
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<ECheckCustom> findCheckRequire(ECheckQueryVo eCheckQueryVo) throws Exception {
		// 带条件进行多表查询+分页查询
		List<ECheckCustom> list = eCheckQueryMapper.selectRequire(eCheckQueryVo);
		if (list.size() == 0) {
			throw new CustomException("未匹配到考勤信息，请更换查找条件！");
		}
		setListWithDaBiao(list); // 给考勤信息设置达标情况
		PageBean<ECheckCustom> pageBean = eCheckQueryVo.getPageBean();
		pageBean.setBeanList(list); // 将考勤信息存到分页类中
		// 带条件查询总记录数
		int count = eCheckQueryMapper.countRequire(eCheckQueryVo);
		pageBean.setTr(count); // 将总记录数存到分页类中

		return pageBean;
	}

	/**
	 * 保存考勤信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void saveCheck(String id, ECheckCustom checkCustom) throws Exception {
		if (id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		// 根据工号和姓名找到员工id
		String staffId = getStaffId(checkCustom);
		// 转移数据到考勤类
		ECheck eCheck = new ECheck();
		BeanUtils.copyProperties(checkCustom, eCheck);
		eCheck.setStaffId(staffId);
		eCheck.setId(id);
		// 保存数据
		int value = eCheckMapper.insertSelective(eCheck);
		if (value == 0) {
			throw new CustomException("保存失败！请重新保存！");
		}
	}

	/**
	 * 根据考勤扩展类中的工号和姓名，找到员工id
	 * 
	 * @param checkCustom
	 * @throws CustomException
	 */
	public String getStaffId(ECheckCustom checkCustom) throws CustomException {
		EStaffExample eStaffExample = new EStaffExample();

		Criteria criteria = eStaffExample.createCriteria();
		criteria.andJobNumEqualTo(checkCustom.getJobNum()); // 工号
		criteria.andNameEqualTo(checkCustom.getStaffName()); // 姓名

		List<EStaff> list = eStaffMapper.selectByExample(eStaffExample); // 借助员工DAO层方法

		if (list.size() == 0) {
			throw new CustomException("填写的员工工号 和 员工姓名 有误！请确认该员工是否存在，再重新提交！");
		}

		return list.get(0).getId();
	}

	/**
	 * 修改考勤信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void updateCheck(String id, ECheckCustom checkCustom) throws Exception {
		if (id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		// 根据工号和姓名找到员工id
		String staffId = getStaffId(checkCustom);
		// 转移数据到考勤类
		ECheck eCheck = new ECheck();
		BeanUtils.copyProperties(checkCustom, eCheck);
		eCheck.setStaffId(staffId);
		eCheck.setId(id);
		// 更新数据
		int value = eCheckMapper.updateByPrimaryKeySelective(eCheck);
		if (value == 0) {
			throw new CustomException("更新失败！其他管理员刚刚进行了更新，您现在获取的不是最新数据！请回到详细信息页面，重新更新！");
		}
	}

	/**
	 * 删除考勤信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void deleteCheck(String id) throws Exception {
		if (id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		int value = eCheckMapper.deleteByPrimaryKey(id);
		if (value == 0) {
			throw new CustomException("删除失败！请重新删除！");
		}
	}

}
