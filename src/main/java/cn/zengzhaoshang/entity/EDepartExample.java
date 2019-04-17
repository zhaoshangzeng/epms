package cn.zengzhaoshang.entity;

import java.util.ArrayList;
import java.util.List;

public class EDepartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EDepartExample() {
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

        public Criteria andDeptNumIsNull() {
            addCriterion("`dept_num` is null");
            return (Criteria) this;
        }

        public Criteria andDeptNumIsNotNull() {
            addCriterion("`dept_num` is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNumEqualTo(String value) {
            addCriterion("`dept_num` =", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumNotEqualTo(String value) {
            addCriterion("`dept_num` <>", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumGreaterThan(String value) {
            addCriterion("`dept_num` >", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumGreaterThanOrEqualTo(String value) {
            addCriterion("`dept_num` >=", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumLessThan(String value) {
            addCriterion("`dept_num` <", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumLessThanOrEqualTo(String value) {
            addCriterion("`dept_num` <=", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumLike(String value) {
            addCriterion("`dept_num` like", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumNotLike(String value) {
            addCriterion("`dept_num` not like", value, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumIn(List<String> values) {
            addCriterion("`dept_num` in", values, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumNotIn(List<String> values) {
            addCriterion("`dept_num` not in", values, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumBetween(String value1, String value2) {
            addCriterion("`dept_num` between", value1, value2, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNumNotBetween(String value1, String value2) {
            addCriterion("`dept_num` not between", value1, value2, "deptNum");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("`dept_name` is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("`dept_name` is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("`dept_name` =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("`dept_name` <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("`dept_name` >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("`dept_name` >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("`dept_name` <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("`dept_name` <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("`dept_name` like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("`dept_name` not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("`dept_name` in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("`dept_name` not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("`dept_name` between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("`dept_name` not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptDescIsNull() {
            addCriterion("`dept_desc` is null");
            return (Criteria) this;
        }

        public Criteria andDeptDescIsNotNull() {
            addCriterion("`dept_desc` is not null");
            return (Criteria) this;
        }

        public Criteria andDeptDescEqualTo(String value) {
            addCriterion("`dept_desc` =", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotEqualTo(String value) {
            addCriterion("`dept_desc` <>", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescGreaterThan(String value) {
            addCriterion("`dept_desc` >", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescGreaterThanOrEqualTo(String value) {
            addCriterion("`dept_desc` >=", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescLessThan(String value) {
            addCriterion("`dept_desc` <", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescLessThanOrEqualTo(String value) {
            addCriterion("`dept_desc` <=", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescLike(String value) {
            addCriterion("`dept_desc` like", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotLike(String value) {
            addCriterion("`dept_desc` not like", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescIn(List<String> values) {
            addCriterion("`dept_desc` in", values, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotIn(List<String> values) {
            addCriterion("`dept_desc` not in", values, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescBetween(String value1, String value2) {
            addCriterion("`dept_desc` between", value1, value2, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotBetween(String value1, String value2) {
            addCriterion("`dept_desc` not between", value1, value2, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptTopIsNull() {
            addCriterion("`dept_top` is null");
            return (Criteria) this;
        }

        public Criteria andDeptTopIsNotNull() {
            addCriterion("`dept_top` is not null");
            return (Criteria) this;
        }

        public Criteria andDeptTopEqualTo(String value) {
            addCriterion("`dept_top` =", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopNotEqualTo(String value) {
            addCriterion("`dept_top` <>", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopGreaterThan(String value) {
            addCriterion("`dept_top` >", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopGreaterThanOrEqualTo(String value) {
            addCriterion("`dept_top` >=", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopLessThan(String value) {
            addCriterion("`dept_top` <", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopLessThanOrEqualTo(String value) {
            addCriterion("`dept_top` <=", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopLike(String value) {
            addCriterion("`dept_top` like", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopNotLike(String value) {
            addCriterion("`dept_top` not like", value, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopIn(List<String> values) {
            addCriterion("`dept_top` in", values, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopNotIn(List<String> values) {
            addCriterion("`dept_top` not in", values, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopBetween(String value1, String value2) {
            addCriterion("`dept_top` between", value1, value2, "deptTop");
            return (Criteria) this;
        }

        public Criteria andDeptTopNotBetween(String value1, String value2) {
            addCriterion("`dept_top` not between", value1, value2, "deptTop");
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