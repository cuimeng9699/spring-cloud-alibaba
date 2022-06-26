package com.example.openfeign.dao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationSqlConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public OperationSqlConfigExample() {
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

    public OperationSqlConfigExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public OperationSqlConfigExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public OperationSqlConfigExample page(Integer page, Integer pageSize) {
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

        public Criteria andOperationTypeIsNull() {
            addCriterion("operation_type is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(String value) {
            addCriterion("operation_type =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(String value) {
            addCriterion("operation_type <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(String value) {
            addCriterion("operation_type >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("operation_type >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(String value) {
            addCriterion("operation_type <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(String value) {
            addCriterion("operation_type <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLike(String value) {
            addCriterion("operation_type like", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotLike(String value) {
            addCriterion("operation_type not like", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<String> values) {
            addCriterion("operation_type in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<String> values) {
            addCriterion("operation_type not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(String value1, String value2) {
            addCriterion("operation_type between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(String value1, String value2) {
            addCriterion("operation_type not between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTableIsNull() {
            addCriterion("operation_table is null");
            return (Criteria) this;
        }

        public Criteria andOperationTableIsNotNull() {
            addCriterion("operation_table is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTableEqualTo(String value) {
            addCriterion("operation_table =", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableNotEqualTo(String value) {
            addCriterion("operation_table <>", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableGreaterThan(String value) {
            addCriterion("operation_table >", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableGreaterThanOrEqualTo(String value) {
            addCriterion("operation_table >=", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableLessThan(String value) {
            addCriterion("operation_table <", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableLessThanOrEqualTo(String value) {
            addCriterion("operation_table <=", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableLike(String value) {
            addCriterion("operation_table like", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableNotLike(String value) {
            addCriterion("operation_table not like", value, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableIn(List<String> values) {
            addCriterion("operation_table in", values, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableNotIn(List<String> values) {
            addCriterion("operation_table not in", values, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableBetween(String value1, String value2) {
            addCriterion("operation_table between", value1, value2, "operationTable");
            return (Criteria) this;
        }

        public Criteria andOperationTableNotBetween(String value1, String value2) {
            addCriterion("operation_table not between", value1, value2, "operationTable");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(String value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(String value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(String value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(String value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(String value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLike(String value) {
            addCriterion("term like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotLike(String value) {
            addCriterion("term not like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<String> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<String> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(String value1, String value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(String value1, String value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andOrderGroupIsNull() {
            addCriterion("order_group is null");
            return (Criteria) this;
        }

        public Criteria andOrderGroupIsNotNull() {
            addCriterion("order_group is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGroupEqualTo(String value) {
            addCriterion("order_group =", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupNotEqualTo(String value) {
            addCriterion("order_group <>", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupGreaterThan(String value) {
            addCriterion("order_group >", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupGreaterThanOrEqualTo(String value) {
            addCriterion("order_group >=", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupLessThan(String value) {
            addCriterion("order_group <", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupLessThanOrEqualTo(String value) {
            addCriterion("order_group <=", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupLike(String value) {
            addCriterion("order_group like", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupNotLike(String value) {
            addCriterion("order_group not like", value, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupIn(List<String> values) {
            addCriterion("order_group in", values, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupNotIn(List<String> values) {
            addCriterion("order_group not in", values, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupBetween(String value1, String value2) {
            addCriterion("order_group between", value1, value2, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andOrderGroupNotBetween(String value1, String value2) {
            addCriterion("order_group not between", value1, value2, "orderGroup");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlIsNull() {
            addCriterion("is_easy_sql is null");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlIsNotNull() {
            addCriterion("is_easy_sql is not null");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlEqualTo(Boolean value) {
            addCriterion("is_easy_sql =", value, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlNotEqualTo(Boolean value) {
            addCriterion("is_easy_sql <>", value, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlGreaterThan(Boolean value) {
            addCriterion("is_easy_sql >", value, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_easy_sql >=", value, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlLessThan(Boolean value) {
            addCriterion("is_easy_sql <", value, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlLessThanOrEqualTo(Boolean value) {
            addCriterion("is_easy_sql <=", value, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlIn(List<Boolean> values) {
            addCriterion("is_easy_sql in", values, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlNotIn(List<Boolean> values) {
            addCriterion("is_easy_sql not in", values, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlBetween(Boolean value1, Boolean value2) {
            addCriterion("is_easy_sql between", value1, value2, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andIsEasySqlNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_easy_sql not between", value1, value2, "isEasySql");
            return (Criteria) this;
        }

        public Criteria andOpreationDescIsNull() {
            addCriterion("opreation_desc is null");
            return (Criteria) this;
        }

        public Criteria andOpreationDescIsNotNull() {
            addCriterion("opreation_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOpreationDescEqualTo(String value) {
            addCriterion("opreation_desc =", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescNotEqualTo(String value) {
            addCriterion("opreation_desc <>", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescGreaterThan(String value) {
            addCriterion("opreation_desc >", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescGreaterThanOrEqualTo(String value) {
            addCriterion("opreation_desc >=", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescLessThan(String value) {
            addCriterion("opreation_desc <", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescLessThanOrEqualTo(String value) {
            addCriterion("opreation_desc <=", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescLike(String value) {
            addCriterion("opreation_desc like", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescNotLike(String value) {
            addCriterion("opreation_desc not like", value, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescIn(List<String> values) {
            addCriterion("opreation_desc in", values, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescNotIn(List<String> values) {
            addCriterion("opreation_desc not in", values, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescBetween(String value1, String value2) {
            addCriterion("opreation_desc between", value1, value2, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andOpreationDescNotBetween(String value1, String value2) {
            addCriterion("opreation_desc not between", value1, value2, "opreationDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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