package cn.zengzhaoshang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EEmployExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EEmployExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("`id` like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("`id` not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("`dept_id` is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("`dept_id` is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("`dept_id` =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("`dept_id` <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("`dept_id` >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("`dept_id` >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("`dept_id` <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("`dept_id` <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("`dept_id` like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("`dept_id` not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("`dept_id` in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("`dept_id` not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("`dept_id` between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("`dept_id` not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("`job_name` is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("`job_name` is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("`job_name` =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("`job_name` <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("`job_name` >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("`job_name` >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("`job_name` <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("`job_name` <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("`job_name` like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("`job_name` not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("`job_name` in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("`job_name` not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("`job_name` between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("`job_name` not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andEmpNumIsNull() {
            addCriterion("`emp_num` is null");
            return (Criteria) this;
        }

        public Criteria andEmpNumIsNotNull() {
            addCriterion("`emp_num` is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNumEqualTo(Short value) {
            addCriterion("`emp_num` =", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumNotEqualTo(Short value) {
            addCriterion("`emp_num` <>", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumGreaterThan(Short value) {
            addCriterion("`emp_num` >", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumGreaterThanOrEqualTo(Short value) {
            addCriterion("`emp_num` >=", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumLessThan(Short value) {
            addCriterion("`emp_num` <", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumLessThanOrEqualTo(Short value) {
            addCriterion("`emp_num` <=", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumIn(List<Short> values) {
            addCriterion("`emp_num` in", values, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumNotIn(List<Short> values) {
            addCriterion("`emp_num` not in", values, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumBetween(Short value1, Short value2) {
            addCriterion("`emp_num` between", value1, value2, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumNotBetween(Short value1, Short value2) {
            addCriterion("`emp_num` not between", value1, value2, "empNum");
            return (Criteria) this;
        }

        public Criteria andJobPayIsNull() {
            addCriterion("`job_pay` is null");
            return (Criteria) this;
        }

        public Criteria andJobPayIsNotNull() {
            addCriterion("`job_pay` is not null");
            return (Criteria) this;
        }

        public Criteria andJobPayEqualTo(String value) {
            addCriterion("`job_pay` =", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayNotEqualTo(String value) {
            addCriterion("`job_pay` <>", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayGreaterThan(String value) {
            addCriterion("`job_pay` >", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayGreaterThanOrEqualTo(String value) {
            addCriterion("`job_pay` >=", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayLessThan(String value) {
            addCriterion("`job_pay` <", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayLessThanOrEqualTo(String value) {
            addCriterion("`job_pay` <=", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayLike(String value) {
            addCriterion("`job_pay` like", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayNotLike(String value) {
            addCriterion("`job_pay` not like", value, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayIn(List<String> values) {
            addCriterion("`job_pay` in", values, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayNotIn(List<String> values) {
            addCriterion("`job_pay` not in", values, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayBetween(String value1, String value2) {
            addCriterion("`job_pay` between", value1, value2, "jobPay");
            return (Criteria) this;
        }

        public Criteria andJobPayNotBetween(String value1, String value2) {
            addCriterion("`job_pay` not between", value1, value2, "jobPay");
            return (Criteria) this;
        }

        public Criteria andEmpDateIsNull() {
            addCriterion("`emp_date` is null");
            return (Criteria) this;
        }

        public Criteria andEmpDateIsNotNull() {
            addCriterion("`emp_date` is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDateEqualTo(Date value) {
            addCriterionForJDBCDate("`emp_date` =", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("`emp_date` <>", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateGreaterThan(Date value) {
            addCriterionForJDBCDate("`emp_date` >", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`emp_date` >=", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateLessThan(Date value) {
            addCriterionForJDBCDate("`emp_date` <", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`emp_date` <=", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateIn(List<Date> values) {
            addCriterionForJDBCDate("`emp_date` in", values, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("`emp_date` not in", values, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`emp_date` between", value1, value2, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`emp_date` not between", value1, value2, "empDate");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpIsNull() {
            addCriterion("`is_now_emp` is null");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpIsNotNull() {
            addCriterion("`is_now_emp` is not null");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpEqualTo(Byte value) {
            addCriterion("`is_now_emp` =", value, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpNotEqualTo(Byte value) {
            addCriterion("`is_now_emp` <>", value, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpGreaterThan(Byte value) {
            addCriterion("`is_now_emp` >", value, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpGreaterThanOrEqualTo(Byte value) {
            addCriterion("`is_now_emp` >=", value, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpLessThan(Byte value) {
            addCriterion("`is_now_emp` <", value, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpLessThanOrEqualTo(Byte value) {
            addCriterion("`is_now_emp` <=", value, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpIn(List<Byte> values) {
            addCriterion("`is_now_emp` in", values, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpNotIn(List<Byte> values) {
            addCriterion("`is_now_emp` not in", values, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpBetween(Byte value1, Byte value2) {
            addCriterion("`is_now_emp` between", value1, value2, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsNowEmpNotBetween(Byte value1, Byte value2) {
            addCriterion("`is_now_emp` not between", value1, value2, "isNowEmp");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNull() {
            addCriterion("`is_finish` is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNotNull() {
            addCriterion("`is_finish` is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishEqualTo(Byte value) {
            addCriterion("`is_finish` =", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotEqualTo(Byte value) {
            addCriterion("`is_finish` <>", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThan(Byte value) {
            addCriterion("`is_finish` >", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThanOrEqualTo(Byte value) {
            addCriterion("`is_finish` >=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThan(Byte value) {
            addCriterion("`is_finish` <", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThanOrEqualTo(Byte value) {
            addCriterion("`is_finish` <=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishIn(List<Byte> values) {
            addCriterion("`is_finish` in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotIn(List<Byte> values) {
            addCriterion("`is_finish` not in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishBetween(Byte value1, Byte value2) {
            addCriterion("`is_finish` between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotBetween(Byte value1, Byte value2) {
            addCriterion("`is_finish` not between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("`version` is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("`version` is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("`version` =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("`version` <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("`version` >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("`version` >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("`version` <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("`version` <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("`version` in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("`version` not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("`version` between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("`version` not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}