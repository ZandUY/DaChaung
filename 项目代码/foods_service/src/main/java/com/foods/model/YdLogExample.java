package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class YdLogExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public YdLogExample() {
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
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
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
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andYdDateIsNull() {
			addCriterion("yd_date is null");
			return (Criteria) this;
		}
		public Criteria andYdDateIsNotNull(){
			addCriterion("yd_date is not null");
			return (Criteria) this;
		}
		public Criteria andYdDateEqualTo(String value) {
			addCriterion("yd_date =", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateNotEqualTo(String value) {
			addCriterion("yd_date <>", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateGreaterThan(String value) {
			addCriterion("yd_date >", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateGreaterThanOrEqualTo(String value) {
			addCriterion("yd_date >=", value, "YdDate");
			return (Criteria) this;
		}
		public Criteria andYdDateLessThan(String value) {
			addCriterion("yd_date <", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateLessThanOrEqualTo(String value) {
			addCriterion("yd_date <=", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateIn(List<String> values) {
			addCriterion("yd_date in", values, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateNotIn(List<String> values) {
			addCriterion("yd_date not in", values, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateBetween(String value1, String value2) {
			addCriterion("yd_date between", value1, value2, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateNotBetween(String value1, String value2) {
			addCriterion("yd_date not between", value1, value2, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateLike(String value) {
			addCriterion("yd_date like", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdDateNotLike(String value) {
			addCriterion("yd_date not like", value, "ydDate");
			return (Criteria) this;
		}
		public Criteria andYdfzsIsNull() {
			addCriterion("ydfzs is null");
			return (Criteria) this;
		}
		public Criteria andYdfzsIsNotNull(){
			addCriterion("ydfzs is not null");
			return (Criteria) this;
		}
		public Criteria andYdfzsEqualTo(Integer value) {
			addCriterion("ydfzs =", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsNotEqualTo(Integer value) {
			addCriterion("ydfzs <>", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsGreaterThan(Integer value) {
			addCriterion("ydfzs >", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsGreaterThanOrEqualTo(Integer value) {
			addCriterion("ydfzs >=", value, "Ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsLessThan(Integer value) {
			addCriterion("ydfzs <", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsLessThanOrEqualTo(Integer value) {
			addCriterion("ydfzs <=", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsIn(List<Integer> values) {
			addCriterion("ydfzs in", values, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsNotIn(List<Integer> values) {
			addCriterion("ydfzs not in", values, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsBetween(Integer value1, Integer value2) {
			addCriterion("ydfzs between", value1, value2, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsNotBetween(Integer value1, Integer value2) {
			addCriterion("ydfzs not between", value1, value2, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsLike(Integer value) {
			addCriterion("ydfzs like", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdfzsNotLike(Integer value) {
			addCriterion("ydfzs not like", value, "ydfzs");
			return (Criteria) this;
		}
		public Criteria andYdTypeIsNull() {
			addCriterion("yd_type is null");
			return (Criteria) this;
		}
		public Criteria andYdTypeIsNotNull(){
			addCriterion("yd_type is not null");
			return (Criteria) this;
		}
		public Criteria andYdTypeEqualTo(Integer value) {
			addCriterion("yd_type =", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeNotEqualTo(Integer value) {
			addCriterion("yd_type <>", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeGreaterThan(Integer value) {
			addCriterion("yd_type >", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("yd_type >=", value, "YdType");
			return (Criteria) this;
		}
		public Criteria andYdTypeLessThan(Integer value) {
			addCriterion("yd_type <", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeLessThanOrEqualTo(Integer value) {
			addCriterion("yd_type <=", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeIn(List<Integer> values) {
			addCriterion("yd_type in", values, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeNotIn(List<Integer> values) {
			addCriterion("yd_type not in", values, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeBetween(Integer value1, Integer value2) {
			addCriterion("yd_type between", value1, value2, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("yd_type not between", value1, value2, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeLike(Integer value) {
			addCriterion("yd_type like", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andYdTypeNotLike(Integer value) {
			addCriterion("yd_type not like", value, "ydType");
			return (Criteria) this;
		}
		public Criteria andMfzxhIsNull() {
			addCriterion("mfzxh is null");
			return (Criteria) this;
		}
		public Criteria andMfzxhIsNotNull(){
			addCriterion("mfzxh is not null");
			return (Criteria) this;
		}
		public Criteria andMfzxhEqualTo(Integer value) {
			addCriterion("mfzxh =", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhNotEqualTo(Integer value) {
			addCriterion("mfzxh <>", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhGreaterThan(Integer value) {
			addCriterion("mfzxh >", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhGreaterThanOrEqualTo(Integer value) {
			addCriterion("mfzxh >=", value, "Mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhLessThan(Integer value) {
			addCriterion("mfzxh <", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhLessThanOrEqualTo(Integer value) {
			addCriterion("mfzxh <=", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhIn(List<Integer> values) {
			addCriterion("mfzxh in", values, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhNotIn(List<Integer> values) {
			addCriterion("mfzxh not in", values, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhBetween(Integer value1, Integer value2) {
			addCriterion("mfzxh between", value1, value2, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhNotBetween(Integer value1, Integer value2) {
			addCriterion("mfzxh not between", value1, value2, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhLike(Integer value) {
			addCriterion("mfzxh like", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andMfzxhNotLike(Integer value) {
			addCriterion("mfzxh not like", value, "mfzxh");
			return (Criteria) this;
		}
		public Criteria andZrNumIsNull() {
			addCriterion("zr_num is null");
			return (Criteria) this;
		}
		public Criteria andZrNumIsNotNull(){
			addCriterion("zr_num is not null");
			return (Criteria) this;
		}
		public Criteria andZrNumEqualTo(Integer value) {
			addCriterion("zr_num =", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumNotEqualTo(Integer value) {
			addCriterion("zr_num <>", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumGreaterThan(Integer value) {
			addCriterion("zr_num >", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("zr_num >=", value, "ZrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumLessThan(Integer value) {
			addCriterion("zr_num <", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumLessThanOrEqualTo(Integer value) {
			addCriterion("zr_num <=", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumIn(List<Integer> values) {
			addCriterion("zr_num in", values, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumNotIn(List<Integer> values) {
			addCriterion("zr_num not in", values, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumBetween(Integer value1, Integer value2) {
			addCriterion("zr_num between", value1, value2, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumNotBetween(Integer value1, Integer value2) {
			addCriterion("zr_num not between", value1, value2, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumLike(Integer value) {
			addCriterion("zr_num like", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andZrNumNotLike(Integer value) {
			addCriterion("zr_num not like", value, "zrNum");
			return (Criteria) this;
		}
		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}
		public Criteria andUserIdIsNotNull(){
			addCriterion("user_id is not null");
			return (Criteria) this;
		}
		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "UserId");
			return (Criteria) this;
		}
		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdLike(Integer value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotLike(Integer value) {
			addCriterion("user_id not like", value, "userId");
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
