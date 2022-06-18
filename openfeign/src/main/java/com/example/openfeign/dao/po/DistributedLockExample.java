package com.example.openfeign.dao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DistributedLockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public DistributedLockExample() {
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
        rows = null;
        offset = null;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public DistributedLockExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public DistributedLockExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public DistributedLockExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLockKeyIsNull() {
            addCriterion("lock_key is null");
            return (Criteria) this;
        }

        public Criteria andLockKeyIsNotNull() {
            addCriterion("lock_key is not null");
            return (Criteria) this;
        }

        public Criteria andLockKeyEqualTo(String value) {
            addCriterion("lock_key =", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyNotEqualTo(String value) {
            addCriterion("lock_key <>", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyGreaterThan(String value) {
            addCriterion("lock_key >", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyGreaterThanOrEqualTo(String value) {
            addCriterion("lock_key >=", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyLessThan(String value) {
            addCriterion("lock_key <", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyLessThanOrEqualTo(String value) {
            addCriterion("lock_key <=", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyLike(String value) {
            addCriterion("lock_key like", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyNotLike(String value) {
            addCriterion("lock_key not like", value, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyIn(List<String> values) {
            addCriterion("lock_key in", values, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyNotIn(List<String> values) {
            addCriterion("lock_key not in", values, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyBetween(String value1, String value2) {
            addCriterion("lock_key between", value1, value2, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockKeyNotBetween(String value1, String value2) {
            addCriterion("lock_key not between", value1, value2, "lockKey");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("lock_status is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Integer value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Integer value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Integer value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Integer value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Integer> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Integer> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Integer value1, Integer value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutIsNull() {
            addCriterion("lock_timeout is null");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutIsNotNull() {
            addCriterion("lock_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutEqualTo(Integer value) {
            addCriterion("lock_timeout =", value, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutNotEqualTo(Integer value) {
            addCriterion("lock_timeout <>", value, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutGreaterThan(Integer value) {
            addCriterion("lock_timeout >", value, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_timeout >=", value, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutLessThan(Integer value) {
            addCriterion("lock_timeout <", value, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("lock_timeout <=", value, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutIn(List<Integer> values) {
            addCriterion("lock_timeout in", values, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutNotIn(List<Integer> values) {
            addCriterion("lock_timeout not in", values, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("lock_timeout between", value1, value2, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_timeout not between", value1, value2, "lockTimeout");
            return (Criteria) this;
        }

        public Criteria andLockByIsNull() {
            addCriterion("lock_by is null");
            return (Criteria) this;
        }

        public Criteria andLockByIsNotNull() {
            addCriterion("lock_by is not null");
            return (Criteria) this;
        }

        public Criteria andLockByEqualTo(String value) {
            addCriterion("lock_by =", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByNotEqualTo(String value) {
            addCriterion("lock_by <>", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByGreaterThan(String value) {
            addCriterion("lock_by >", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByGreaterThanOrEqualTo(String value) {
            addCriterion("lock_by >=", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByLessThan(String value) {
            addCriterion("lock_by <", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByLessThanOrEqualTo(String value) {
            addCriterion("lock_by <=", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByLike(String value) {
            addCriterion("lock_by like", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByNotLike(String value) {
            addCriterion("lock_by not like", value, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByIn(List<String> values) {
            addCriterion("lock_by in", values, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByNotIn(List<String> values) {
            addCriterion("lock_by not in", values, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByBetween(String value1, String value2) {
            addCriterion("lock_by between", value1, value2, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockByNotBetween(String value1, String value2) {
            addCriterion("lock_by not between", value1, value2, "lockBy");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNull() {
            addCriterion("lock_time is null");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNotNull() {
            addCriterion("lock_time is not null");
            return (Criteria) this;
        }

        public Criteria andLockTimeEqualTo(Date value) {
            addCriterion("lock_time =", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotEqualTo(Date value) {
            addCriterion("lock_time <>", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThan(Date value) {
            addCriterion("lock_time >", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lock_time >=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThan(Date value) {
            addCriterion("lock_time <", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThanOrEqualTo(Date value) {
            addCriterion("lock_time <=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeIn(List<Date> values) {
            addCriterion("lock_time in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotIn(List<Date> values) {
            addCriterion("lock_time not in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeBetween(Date value1, Date value2) {
            addCriterion("lock_time between", value1, value2, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotBetween(Date value1, Date value2) {
            addCriterion("lock_time not between", value1, value2, "lockTime");
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