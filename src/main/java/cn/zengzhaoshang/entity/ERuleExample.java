package cn.zengzhaoshang.entity;

import java.util.ArrayList;
import java.util.List;

public class ERuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ERuleExample() {
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

        public Criteria andIdEqualTo(Byte value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Byte value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Byte value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Byte value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Byte value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Byte> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Byte> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Byte value1, Byte value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Byte value1, Byte value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMaxLateIsNull() {
            addCriterion("`max_late` is null");
            return (Criteria) this;
        }

        public Criteria andMaxLateIsNotNull() {
            addCriterion("`max_late` is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLateEqualTo(Byte value) {
            addCriterion("`max_late` =", value, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateNotEqualTo(Byte value) {
            addCriterion("`max_late` <>", value, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateGreaterThan(Byte value) {
            addCriterion("`max_late` >", value, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateGreaterThanOrEqualTo(Byte value) {
            addCriterion("`max_late` >=", value, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateLessThan(Byte value) {
            addCriterion("`max_late` <", value, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateLessThanOrEqualTo(Byte value) {
            addCriterion("`max_late` <=", value, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateIn(List<Byte> values) {
            addCriterion("`max_late` in", values, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateNotIn(List<Byte> values) {
            addCriterion("`max_late` not in", values, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateBetween(Byte value1, Byte value2) {
            addCriterion("`max_late` between", value1, value2, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxLateNotBetween(Byte value1, Byte value2) {
            addCriterion("`max_late` not between", value1, value2, "maxLate");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyIsNull() {
            addCriterion("`max_early` is null");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyIsNotNull() {
            addCriterion("`max_early` is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyEqualTo(Byte value) {
            addCriterion("`max_early` =", value, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyNotEqualTo(Byte value) {
            addCriterion("`max_early` <>", value, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyGreaterThan(Byte value) {
            addCriterion("`max_early` >", value, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyGreaterThanOrEqualTo(Byte value) {
            addCriterion("`max_early` >=", value, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyLessThan(Byte value) {
            addCriterion("`max_early` <", value, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyLessThanOrEqualTo(Byte value) {
            addCriterion("`max_early` <=", value, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyIn(List<Byte> values) {
            addCriterion("`max_early` in", values, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyNotIn(List<Byte> values) {
            addCriterion("`max_early` not in", values, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyBetween(Byte value1, Byte value2) {
            addCriterion("`max_early` between", value1, value2, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxEarlyNotBetween(Byte value1, Byte value2) {
            addCriterion("`max_early` not between", value1, value2, "maxEarly");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceIsNull() {
            addCriterion("`max_absence` is null");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceIsNotNull() {
            addCriterion("`max_absence` is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceEqualTo(Byte value) {
            addCriterion("`max_absence` =", value, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceNotEqualTo(Byte value) {
            addCriterion("`max_absence` <>", value, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceGreaterThan(Byte value) {
            addCriterion("`max_absence` >", value, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceGreaterThanOrEqualTo(Byte value) {
            addCriterion("`max_absence` >=", value, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceLessThan(Byte value) {
            addCriterion("`max_absence` <", value, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceLessThanOrEqualTo(Byte value) {
            addCriterion("`max_absence` <=", value, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceIn(List<Byte> values) {
            addCriterion("`max_absence` in", values, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceNotIn(List<Byte> values) {
            addCriterion("`max_absence` not in", values, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceBetween(Byte value1, Byte value2) {
            addCriterion("`max_absence` between", value1, value2, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxAbsenceNotBetween(Byte value1, Byte value2) {
            addCriterion("`max_absence` not between", value1, value2, "maxAbsence");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveIsNull() {
            addCriterion("`max_leave` is null");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveIsNotNull() {
            addCriterion("`max_leave` is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveEqualTo(Byte value) {
            addCriterion("`max_leave` =", value, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveNotEqualTo(Byte value) {
            addCriterion("`max_leave` <>", value, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveGreaterThan(Byte value) {
            addCriterion("`max_leave` >", value, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveGreaterThanOrEqualTo(Byte value) {
            addCriterion("`max_leave` >=", value, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveLessThan(Byte value) {
            addCriterion("`max_leave` <", value, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveLessThanOrEqualTo(Byte value) {
            addCriterion("`max_leave` <=", value, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveIn(List<Byte> values) {
            addCriterion("`max_leave` in", values, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveNotIn(List<Byte> values) {
            addCriterion("`max_leave` not in", values, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveBetween(Byte value1, Byte value2) {
            addCriterion("`max_leave` between", value1, value2, "maxLeave");
            return (Criteria) this;
        }

        public Criteria andMaxLeaveNotBetween(Byte value1, Byte value2) {
            addCriterion("`max_leave` not between", value1, value2, "maxLeave");
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