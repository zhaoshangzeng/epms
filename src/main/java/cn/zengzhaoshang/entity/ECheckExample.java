package cn.zengzhaoshang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ECheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ECheckExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("`staff_id` is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("`staff_id` is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("`staff_id` =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("`staff_id` <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("`staff_id` >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("`staff_id` >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("`staff_id` <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("`staff_id` <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("`staff_id` like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("`staff_id` not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("`staff_id` in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("`staff_id` not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("`staff_id` between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("`staff_id` not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("`check_date` is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("`check_date` is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterionForJDBCDate("`check_date` =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("`check_date` <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterionForJDBCDate("`check_date` >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`check_date` >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterionForJDBCDate("`check_date` <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`check_date` <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterionForJDBCDate("`check_date` in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("`check_date` not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`check_date` between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`check_date` not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andLateNumIsNull() {
            addCriterion("`late_num` is null");
            return (Criteria) this;
        }

        public Criteria andLateNumIsNotNull() {
            addCriterion("`late_num` is not null");
            return (Criteria) this;
        }

        public Criteria andLateNumEqualTo(Byte value) {
            addCriterion("`late_num` =", value, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumNotEqualTo(Byte value) {
            addCriterion("`late_num` <>", value, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumGreaterThan(Byte value) {
            addCriterion("`late_num` >", value, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("`late_num` >=", value, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumLessThan(Byte value) {
            addCriterion("`late_num` <", value, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumLessThanOrEqualTo(Byte value) {
            addCriterion("`late_num` <=", value, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumIn(List<Byte> values) {
            addCriterion("`late_num` in", values, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumNotIn(List<Byte> values) {
            addCriterion("`late_num` not in", values, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumBetween(Byte value1, Byte value2) {
            addCriterion("`late_num` between", value1, value2, "lateNum");
            return (Criteria) this;
        }

        public Criteria andLateNumNotBetween(Byte value1, Byte value2) {
            addCriterion("`late_num` not between", value1, value2, "lateNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumIsNull() {
            addCriterion("`early_num` is null");
            return (Criteria) this;
        }

        public Criteria andEarlyNumIsNotNull() {
            addCriterion("`early_num` is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyNumEqualTo(Byte value) {
            addCriterion("`early_num` =", value, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumNotEqualTo(Byte value) {
            addCriterion("`early_num` <>", value, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumGreaterThan(Byte value) {
            addCriterion("`early_num` >", value, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("`early_num` >=", value, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumLessThan(Byte value) {
            addCriterion("`early_num` <", value, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumLessThanOrEqualTo(Byte value) {
            addCriterion("`early_num` <=", value, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumIn(List<Byte> values) {
            addCriterion("`early_num` in", values, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumNotIn(List<Byte> values) {
            addCriterion("`early_num` not in", values, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumBetween(Byte value1, Byte value2) {
            addCriterion("`early_num` between", value1, value2, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andEarlyNumNotBetween(Byte value1, Byte value2) {
            addCriterion("`early_num` not between", value1, value2, "earlyNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumIsNull() {
            addCriterion("`absence_num` is null");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumIsNotNull() {
            addCriterion("`absence_num` is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumEqualTo(Byte value) {
            addCriterion("`absence_num` =", value, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumNotEqualTo(Byte value) {
            addCriterion("`absence_num` <>", value, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumGreaterThan(Byte value) {
            addCriterion("`absence_num` >", value, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("`absence_num` >=", value, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumLessThan(Byte value) {
            addCriterion("`absence_num` <", value, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumLessThanOrEqualTo(Byte value) {
            addCriterion("`absence_num` <=", value, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumIn(List<Byte> values) {
            addCriterion("`absence_num` in", values, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumNotIn(List<Byte> values) {
            addCriterion("`absence_num` not in", values, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumBetween(Byte value1, Byte value2) {
            addCriterion("`absence_num` between", value1, value2, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andAbsenceNumNotBetween(Byte value1, Byte value2) {
            addCriterion("`absence_num` not between", value1, value2, "absenceNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumIsNull() {
            addCriterion("`leave_num` is null");
            return (Criteria) this;
        }

        public Criteria andLeaveNumIsNotNull() {
            addCriterion("`leave_num` is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveNumEqualTo(Byte value) {
            addCriterion("`leave_num` =", value, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumNotEqualTo(Byte value) {
            addCriterion("`leave_num` <>", value, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumGreaterThan(Byte value) {
            addCriterion("`leave_num` >", value, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("`leave_num` >=", value, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumLessThan(Byte value) {
            addCriterion("`leave_num` <", value, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumLessThanOrEqualTo(Byte value) {
            addCriterion("`leave_num` <=", value, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumIn(List<Byte> values) {
            addCriterion("`leave_num` in", values, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumNotIn(List<Byte> values) {
            addCriterion("`leave_num` not in", values, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumBetween(Byte value1, Byte value2) {
            addCriterion("`leave_num` between", value1, value2, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andLeaveNumNotBetween(Byte value1, Byte value2) {
            addCriterion("`leave_num` not between", value1, value2, "leaveNum");
            return (Criteria) this;
        }

        public Criteria andTripNumIsNull() {
            addCriterion("`trip_num` is null");
            return (Criteria) this;
        }

        public Criteria andTripNumIsNotNull() {
            addCriterion("`trip_num` is not null");
            return (Criteria) this;
        }

        public Criteria andTripNumEqualTo(Byte value) {
            addCriterion("`trip_num` =", value, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumNotEqualTo(Byte value) {
            addCriterion("`trip_num` <>", value, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumGreaterThan(Byte value) {
            addCriterion("`trip_num` >", value, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("`trip_num` >=", value, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumLessThan(Byte value) {
            addCriterion("`trip_num` <", value, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumLessThanOrEqualTo(Byte value) {
            addCriterion("`trip_num` <=", value, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumIn(List<Byte> values) {
            addCriterion("`trip_num` in", values, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumNotIn(List<Byte> values) {
            addCriterion("`trip_num` not in", values, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumBetween(Byte value1, Byte value2) {
            addCriterion("`trip_num` between", value1, value2, "tripNum");
            return (Criteria) this;
        }

        public Criteria andTripNumNotBetween(Byte value1, Byte value2) {
            addCriterion("`trip_num` not between", value1, value2, "tripNum");
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