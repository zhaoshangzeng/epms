package cn.zengzhaoshang.test.dao;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.zengzhaoshang.dao.EAccountMapper;
import cn.zengzhaoshang.dao.ECheckQueryMapper;
import cn.zengzhaoshang.dao.EDepartQueryMapper;
import cn.zengzhaoshang.dao.EEmployQueryMapper;
import cn.zengzhaoshang.dao.EStaffMapper;
import cn.zengzhaoshang.dao.EStaffQueryMapper;
import cn.zengzhaoshang.dao.ETrainQueryMapper;
import cn.zengzhaoshang.dto.ECheckCustom;
import cn.zengzhaoshang.dto.EDepartCustom;
import cn.zengzhaoshang.dto.EEmployCustom;
import cn.zengzhaoshang.dto.EStaffCustom;
import cn.zengzhaoshang.dto.ETrainCustom;
import cn.zengzhaoshang.entity.EAccount;
import cn.zengzhaoshang.entity.EAccountExample;
import cn.zengzhaoshang.entity.EStaffExample;

/**
 * 
 * @Title: DaoTest
 * @Description dao层代码测试
 * @author zengzhaoshang
 * @date: 2019年3月24日 上午9:37:55  
 * @version v1.0
 */
public class DaoTest{
	
	SqlSession sqlSession;
	
//	@Before
	public void testBefore() throws IOException {
		//配置文件
		String resource = "mybatis/SqlMapConfig.xml";
		//获得配置文件流
		InputStream config = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
		//通过工厂得到session
		sqlSession = factory.openSession();
	}
	
	/**
	 * 测试版本控制---乐观锁
	 * @throws IOException 
	 */
//	@Test
	public void testVersion(){
		EAccountMapper mapper = sqlSession.getMapper(EAccountMapper.class);
		EAccount eAccount = new EAccount();
		eAccount.setId("11");
		eAccount.setName("aaa");
		eAccount.setPassword("aaa");
		eAccount.setPower((byte) 1);
		eAccount.setVersion(1);
		int isUp = mapper.updateByPrimaryKeySelective(eAccount);
		sqlSession.commit();
		System.out.println(isUp==1?"更新成功":"更新失败");
	}
	
	/**
	 * 测试不带条件查找所有信息
	 * @throws IOException 
	 */
//	@Test
	public void testFindAll(){
		EAccountMapper mapper = sqlSession.getMapper(EAccountMapper.class);
		List<EAccount> list = mapper.selectByExample(new EAccountExample());
		System.out.println(list);
	}
	
	/**
	 * 查询培训包含部门的信息
	 */
//	@Test
	public void testFindTrainWithDept(){
		ETrainQueryMapper mapper = sqlSession.getMapper(ETrainQueryMapper.class);
		ETrainCustom ets = mapper.selectByPrimaryKey("425120335D2346D4991A662E22E50640");
		System.out.println(ets);
	}
	
	/**
	 * 查询招聘包含部门的信息
	 */
//	@Test
	public void testFindEmployWithDept(){
		EEmployQueryMapper mapper = sqlSession.getMapper(EEmployQueryMapper.class);
		EEmployCustom ecs = mapper.selectByPrimaryKey("425120385D2346D4991A662E22E50640");
		System.out.println(ecs);
	}
	
	/**
	 * 查询部门完整的信息
	 */
//	@Test
	public void testFindDeptWithTop(){
		EDepartQueryMapper mapper = sqlSession.getMapper(EDepartQueryMapper.class);
		EDepartCustom edc = mapper.selectByPrimaryKey("425120365D1346D4991A662E22E50640");
		System.out.println(edc);
	}
	
	/**
	 * 查询员工包含部门的信息
	 */
//	@Test
	public void testFindStaffWithDept(){
		EStaffQueryMapper mapper = sqlSession.getMapper(EStaffQueryMapper.class);
		EStaffCustom esc = mapper.selectByPrimaryKey("425120385D1346D4991A662E22E50640");
		System.out.println(esc);
	}
	
	/**
	 * 查询考勤包含员工的信息
	 */
//	@Test
	public void testFindCheckWithStaff(){
		ECheckQueryMapper mapper = sqlSession.getMapper(ECheckQueryMapper.class);
		ECheckCustom ecc = mapper.selectByPrimaryKey("425120265D1346D4991A662E22E50641");
		System.out.println(ecc);
	}
	
	/**
	 * 根据月份查找考勤信息
	 * @throws ParseException 
	 */
//	@Test
	public void testFindCheck() throws ParseException {
		//获取今年年份的字符串形式
		Date d = new Date();
//		d.setMonth(d.getMonth()-1);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d); // 设置为当前时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
		d = calendar.getTime();
		String month = new SimpleDateFormat("yyyy-MM").format(d);
		Date date = new SimpleDateFormat("yyyy-MM").parse(month);
		
		System.out.println(month + "\n" + date);
		
		ECheckQueryMapper mapper = sqlSession.getMapper(ECheckQueryMapper.class);
		List<ECheckCustom> list = mapper.selectByMonth(date);
		
		System.out.println(list.size());
		System.out.println(list);
	}
	
	/**
	 * 测试获取员工总记录数
	 */
//	@Test
	public void showCount() {
		EStaffMapper mapper = sqlSession.getMapper(EStaffMapper.class);
		long count = mapper.countByExample(new EStaffExample());
		System.out.println(count);
	}
	
	/**
	 * 测试基本类型封装类计算
	 */
//	@Test
	public void testJS() {
		Integer tp = 3;
		Integer ps = 2;
		Integer tr = 5;
		tp = tr / ps;
		tp = (tr%ps == 0 ? tp : tp + 1);
		System.out.println(tp);
	}
}
