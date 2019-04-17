package cn.zengzhaoshang.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 用于分页的javabean
 * @author zengzhaoshang
 *
 * 原理分析：（也是分页的代码执行流程）
 * JSP页面要传递给控制器一个当前页面（第几页）的数据，称为pc page code
 * 控制器收到该数据
 * 控制器定义一个页面要展示多少条记录的数据，称为ps page size
 * 控制器new一个分页类，将这两个数据存到分页类中
 * 控制器将分页类传给业务层
 * 业务层将分页类传给Dao持久层
 * 持久层查询总记录数，称为tr total record
 * 		使用的SQL语句是：select count(*) from 表名
 * 持久层分页查询数据，Mybatis会以List集合返还数据
 * 		使用的SQL语句是：select * from 表名 limit 从第几条记录开始查, 要查询几条;
 * 将以上的查询结果存到分页类
 * 分页类内部根据总记录数 和 每页要展示多少条记录的数据  计算出 共几页
 * 将分页类传回给控制器
 * 控制器将分页类传到JSP页面
 * JSP页面使用EL表达式拿到分页类
 * 根据分页类中的数据，可以展示当前第几页、共几页、当前页的所有数据、下一页为当前页+1、上一页为当前页-1、首页为第一页、尾页为最大页
 *
 * 分工流程：
 * 页面：给出相关的链接们
 * servlet：1.获取当前页面，即pc
 * 		   2.指定ps，即指定每页记录数
 * 		   3.传递给service的参数是pc，和ps，service返回PageBean对象
 * 		   4.把PageBean保存到request域，转发给页面
 * service：即Dao方法的包装
 * Dao：
 * 		1.得到pc和ps，创建出PageBean
 * 		2.要查询数据库得到tr，和beanMap
 * 		3.返回PageBean
 * 		操作：
 *		tr：select count(*) from e_depart
 * 	   beanList：select * from e_depart limit x,y;
 * 理解：即在原查询beanList的基础上，再查询tr，而且还有修改原查询，修改成有limit的sql语句。
 */
public class PageBean<T> implements Serializable{
	
	private static final long serialVersionUID = 1L; //序列化id
	
	private Integer pc; //当前页码page code （jsp请求时会给）
//	private Integer tp; //总页数total page //因为是根据其他属性值算出的，只提供get方法
	private Integer tr; //总记录数total record （到数据库查询COUNT(*)，获得Number类型，intValue转）
	private Integer ps; //每页记录数page size （根据页面大小，自己指定）
	private List<T> beanList; //当前页的记录	  （用pc和ps，到数据库查询limit (pc-1)*ps,ps）
//	private Integer lc; //仅用于mysql数据库limit语句第一个参数值设置，意思是从第几个开始查询，也是算出来的
	
	private String url; //当使用条件查询时，它是url后面的条件
	
	/**
	 * @return the lc 用于mysql数据库limit语句第一个参数值
	 */
	public Integer getLc() {
		return (pc-1)*ps;
	}
	
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	/**
	 * 返回总页数
	 * @return
	 */
	public Integer getTp() {
		Integer tp = tr / ps;
		tp = (tr%ps == 0 ? tp : tp + 1);  //默认是相除结果再加1，但遇到刚刚好满一页的情况，如10/10，则不加
		return tp;
	}
//	public void setTp(int tp) {	//避免外界设置它，因为它是固定的
//		this.tp = tp;
//	}
	public Integer getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public Integer getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanList == null) ? 0 : beanList.hashCode());
		result = prime * result + pc;
		result = prime * result + ps;
		result = prime * result + tr;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PageBean)) {
			return false;
		}
		PageBean<?> other = (PageBean<?>) obj;
		if (beanList == null) {
			if (other.beanList != null) {
				return false;
			}
		} else if (!beanList.equals(other.beanList)) {
			return false;
		}
		if (pc != other.pc) {
			return false;
		}
		if (ps != other.ps) {
			return false;
		}
		if (tr != other.tr) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageBean [pc=" + pc + ", tr=" + tr + ", ps=" + ps + ", beanList=" + beanList + ", url=" + url + "]";
	}
}
