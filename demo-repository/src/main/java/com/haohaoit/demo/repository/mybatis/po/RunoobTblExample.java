package com.haohaoit.demo.repository.mybatis.po;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RunoobTblExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RunoobTblExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andRunoobIdIsNull() {
            addCriterion("runoob_id is null");
            return (Criteria) this;
        }

        public Criteria andRunoobIdIsNotNull() {
            addCriterion("runoob_id is not null");
            return (Criteria) this;
        }

        public Criteria andRunoobIdEqualTo(Integer value) {
            addCriterion("runoob_id =", value, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdNotEqualTo(Integer value) {
            addCriterion("runoob_id <>", value, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdGreaterThan(Integer value) {
            addCriterion("runoob_id >", value, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("runoob_id >=", value, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdLessThan(Integer value) {
            addCriterion("runoob_id <", value, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdLessThanOrEqualTo(Integer value) {
            addCriterion("runoob_id <=", value, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdIn(List<Integer> values) {
            addCriterion("runoob_id in", values, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdNotIn(List<Integer> values) {
            addCriterion("runoob_id not in", values, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdBetween(Integer value1, Integer value2) {
            addCriterion("runoob_id between", value1, value2, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("runoob_id not between", value1, value2, "runoobId");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleIsNull() {
            addCriterion("runoob_title is null");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleIsNotNull() {
            addCriterion("runoob_title is not null");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleEqualTo(String value) {
            addCriterion("runoob_title =", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleNotEqualTo(String value) {
            addCriterion("runoob_title <>", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleGreaterThan(String value) {
            addCriterion("runoob_title >", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleGreaterThanOrEqualTo(String value) {
            addCriterion("runoob_title >=", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleLessThan(String value) {
            addCriterion("runoob_title <", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleLessThanOrEqualTo(String value) {
            addCriterion("runoob_title <=", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleLike(String value) {
            addCriterion("runoob_title like", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleNotLike(String value) {
            addCriterion("runoob_title not like", value, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleIn(List<String> values) {
            addCriterion("runoob_title in", values, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleNotIn(List<String> values) {
            addCriterion("runoob_title not in", values, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleBetween(String value1, String value2) {
            addCriterion("runoob_title between", value1, value2, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobTitleNotBetween(String value1, String value2) {
            addCriterion("runoob_title not between", value1, value2, "runoobTitle");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorIsNull() {
            addCriterion("runoob_author is null");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorIsNotNull() {
            addCriterion("runoob_author is not null");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorEqualTo(String value) {
            addCriterion("runoob_author =", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorNotEqualTo(String value) {
            addCriterion("runoob_author <>", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorGreaterThan(String value) {
            addCriterion("runoob_author >", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("runoob_author >=", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorLessThan(String value) {
            addCriterion("runoob_author <", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorLessThanOrEqualTo(String value) {
            addCriterion("runoob_author <=", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorLike(String value) {
            addCriterion("runoob_author like", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorNotLike(String value) {
            addCriterion("runoob_author not like", value, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorIn(List<String> values) {
            addCriterion("runoob_author in", values, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorNotIn(List<String> values) {
            addCriterion("runoob_author not in", values, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorBetween(String value1, String value2) {
            addCriterion("runoob_author between", value1, value2, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andRunoobAuthorNotBetween(String value1, String value2) {
            addCriterion("runoob_author not between", value1, value2, "runoobAuthor");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateIsNull() {
            addCriterion("submission_date is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateIsNotNull() {
            addCriterion("submission_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateEqualTo(LocalDate value) {
            addCriterion("submission_date =", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotEqualTo(LocalDate value) {
            addCriterion("submission_date <>", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateGreaterThan(LocalDate value) {
            addCriterion("submission_date >", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("submission_date >=", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateLessThan(LocalDate value) {
            addCriterion("submission_date <", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("submission_date <=", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateIn(List<LocalDate> values) {
            addCriterion("submission_date in", values, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotIn(List<LocalDate> values) {
            addCriterion("submission_date not in", values, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("submission_date between", value1, value2, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("submission_date not between", value1, value2, "submissionDate");
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