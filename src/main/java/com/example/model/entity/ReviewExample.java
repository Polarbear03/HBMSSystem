package com.example.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ReviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReviewExample() {
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

        public Criteria andReviewidIsNull() {
            addCriterion("ReviewID is null");
            return (Criteria) this;
        }

        public Criteria andReviewidIsNotNull() {
            addCriterion("ReviewID is not null");
            return (Criteria) this;
        }

        public Criteria andReviewidEqualTo(Integer value) {
            addCriterion("ReviewID =", value, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidNotEqualTo(Integer value) {
            addCriterion("ReviewID <>", value, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidGreaterThan(Integer value) {
            addCriterion("ReviewID >", value, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReviewID >=", value, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidLessThan(Integer value) {
            addCriterion("ReviewID <", value, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidLessThanOrEqualTo(Integer value) {
            addCriterion("ReviewID <=", value, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidIn(List<Integer> values) {
            addCriterion("ReviewID in", values, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidNotIn(List<Integer> values) {
            addCriterion("ReviewID not in", values, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidBetween(Integer value1, Integer value2) {
            addCriterion("ReviewID between", value1, value2, "reviewid");
            return (Criteria) this;
        }

        public Criteria andReviewidNotBetween(Integer value1, Integer value2) {
            addCriterion("ReviewID not between", value1, value2, "reviewid");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("OrderID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("OrderID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("OrderID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("OrderID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("OrderID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("OrderID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("OrderID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("OrderID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("OrderID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("OrderID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andReviewcontentIsNull() {
            addCriterion("ReviewContent is null");
            return (Criteria) this;
        }

        public Criteria andReviewcontentIsNotNull() {
            addCriterion("ReviewContent is not null");
            return (Criteria) this;
        }

        public Criteria andReviewcontentEqualTo(String value) {
            addCriterion("ReviewContent =", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentNotEqualTo(String value) {
            addCriterion("ReviewContent <>", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentGreaterThan(String value) {
            addCriterion("ReviewContent >", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentGreaterThanOrEqualTo(String value) {
            addCriterion("ReviewContent >=", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentLessThan(String value) {
            addCriterion("ReviewContent <", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentLessThanOrEqualTo(String value) {
            addCriterion("ReviewContent <=", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentLike(String value) {
            addCriterion("ReviewContent like", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentNotLike(String value) {
            addCriterion("ReviewContent not like", value, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentIn(List<String> values) {
            addCriterion("ReviewContent in", values, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentNotIn(List<String> values) {
            addCriterion("ReviewContent not in", values, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentBetween(String value1, String value2) {
            addCriterion("ReviewContent between", value1, value2, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewcontentNotBetween(String value1, String value2) {
            addCriterion("ReviewContent not between", value1, value2, "reviewcontent");
            return (Criteria) this;
        }

        public Criteria andReviewratingIsNull() {
            addCriterion("ReviewRating is null");
            return (Criteria) this;
        }

        public Criteria andReviewratingIsNotNull() {
            addCriterion("ReviewRating is not null");
            return (Criteria) this;
        }

        public Criteria andReviewratingEqualTo(Integer value) {
            addCriterion("ReviewRating =", value, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingNotEqualTo(Integer value) {
            addCriterion("ReviewRating <>", value, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingGreaterThan(Integer value) {
            addCriterion("ReviewRating >", value, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReviewRating >=", value, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingLessThan(Integer value) {
            addCriterion("ReviewRating <", value, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingLessThanOrEqualTo(Integer value) {
            addCriterion("ReviewRating <=", value, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingIn(List<Integer> values) {
            addCriterion("ReviewRating in", values, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingNotIn(List<Integer> values) {
            addCriterion("ReviewRating not in", values, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingBetween(Integer value1, Integer value2) {
            addCriterion("ReviewRating between", value1, value2, "reviewrating");
            return (Criteria) this;
        }

        public Criteria andReviewratingNotBetween(Integer value1, Integer value2) {
            addCriterion("ReviewRating not between", value1, value2, "reviewrating");
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