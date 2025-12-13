package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class YsLogExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public YsLogExample() {
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
		public Criteria andYsDateIsNull() {
			addCriterion("ys_date is null");
			return (Criteria) this;
		}
		public Criteria andYsDateIsNotNull(){
			addCriterion("ys_date is not null");
			return (Criteria) this;
		}
		public Criteria andYsDateEqualTo(String value) {
			addCriterion("ys_date =", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateNotEqualTo(String value) {
			addCriterion("ys_date <>", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateGreaterThan(String value) {
			addCriterion("ys_date >", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateGreaterThanOrEqualTo(String value) {
			addCriterion("ys_date >=", value, "YsDate");
			return (Criteria) this;
		}
		public Criteria andYsDateLessThan(String value) {
			addCriterion("ys_date <", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateLessThanOrEqualTo(String value) {
			addCriterion("ys_date <=", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateIn(List<String> values) {
			addCriterion("ys_date in", values, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateNotIn(List<String> values) {
			addCriterion("ys_date not in", values, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateBetween(String value1, String value2) {
			addCriterion("ys_date between", value1, value2, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateNotBetween(String value1, String value2) {
			addCriterion("ys_date not between", value1, value2, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateLike(String value) {
			addCriterion("ys_date like", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsDateNotLike(String value) {
			addCriterion("ys_date not like", value, "ysDate");
			return (Criteria) this;
		}
		public Criteria andYsTimeIsNull() {
			addCriterion("ys_time is null");
			return (Criteria) this;
		}
		public Criteria andYsTimeIsNotNull(){
			addCriterion("ys_time is not null");
			return (Criteria) this;
		}
		public Criteria andYsTimeEqualTo(Integer value) {
			addCriterion("ys_time =", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeNotEqualTo(Integer value) {
			addCriterion("ys_time <>", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeGreaterThan(Integer value) {
			addCriterion("ys_time >", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ys_time >=", value, "YsTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeLessThan(Integer value) {
			addCriterion("ys_time <", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeLessThanOrEqualTo(Integer value) {
			addCriterion("ys_time <=", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeIn(List<Integer> values) {
			addCriterion("ys_time in", values, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeNotIn(List<Integer> values) {
			addCriterion("ys_time not in", values, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeBetween(Integer value1, Integer value2) {
			addCriterion("ys_time between", value1, value2, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("ys_time not between", value1, value2, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeLike(Integer value) {
			addCriterion("ys_time like", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTimeNotLike(Integer value) {
			addCriterion("ys_time not like", value, "ysTime");
			return (Criteria) this;
		}
		public Criteria andYsTypeIsNull() {
			addCriterion("ys_type is null");
			return (Criteria) this;
		}
		public Criteria andYsTypeIsNotNull(){
			addCriterion("ys_type is not null");
			return (Criteria) this;
		}
		public Criteria andYsTypeEqualTo(Integer value) {
			addCriterion("ys_type =", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeNotEqualTo(Integer value) {
			addCriterion("ys_type <>", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeGreaterThan(Integer value) {
			addCriterion("ys_type >", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ys_type >=", value, "YsType");
			return (Criteria) this;
		}
		public Criteria andYsTypeLessThan(Integer value) {
			addCriterion("ys_type <", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeLessThanOrEqualTo(Integer value) {
			addCriterion("ys_type <=", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeIn(List<Integer> values) {
			addCriterion("ys_type in", values, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeNotIn(List<Integer> values) {
			addCriterion("ys_type not in", values, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeBetween(Integer value1, Integer value2) {
			addCriterion("ys_type between", value1, value2, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ys_type not between", value1, value2, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeLike(Integer value) {
			addCriterion("ys_type like", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andYsTypeNotLike(Integer value) {
			addCriterion("ys_type not like", value, "ysType");
			return (Criteria) this;
		}
		public Criteria andMqkrNumIsNull() {
			addCriterion("mqkr_num is null");
			return (Criteria) this;
		}
		public Criteria andMqkrNumIsNotNull(){
			addCriterion("mqkr_num is not null");
			return (Criteria) this;
		}
		public Criteria andMqkrNumEqualTo(Integer value) {
			addCriterion("mqkr_num =", value, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumNotEqualTo(Integer value) {
			addCriterion("mqkr_num <>", value, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumGreaterThan(Integer value) {
			addCriterion("mqkr_num >", value, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("mqkr_num >=", value, "MqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumLessThan(Integer value) {
			addCriterion("mqkr_num <", value, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumLessThanOrEqualTo(Integer value) {
			addCriterion("mqkr_num <=", value, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumIn(List<Integer> values) {
			addCriterion("mqkr_num in", values, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumNotIn(List<Integer> values) {
			addCriterion("mqkr_num not in", values, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumBetween(Integer value1, Integer value2) {
			addCriterion("mqkr_num between", value1, value2, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumNotBetween(Integer value1, Integer value2) {
			addCriterion("mqkr_num not between", value1, value2, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumLike(Integer value) {
			addCriterion("mqkr_num like", value, "mqkrNum");
			return (Criteria) this;
		}
		public Criteria andMqkrNumNotLike(Integer value) {
			addCriterion("mqkr_num not like", value, "mqkrNum");
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
		public Criteria andZrlIsNull() {
			addCriterion("zrl is null");
			return (Criteria) this;
		}
		public Criteria andZrlIsNotNull(){
			addCriterion("zrl is not null");
			return (Criteria) this;
		}
		public Criteria andZrlEqualTo(Integer value) {
			addCriterion("zrl =", value, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlNotEqualTo(Integer value) {
			addCriterion("zrl <>", value, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlGreaterThan(Integer value) {
			addCriterion("zrl >", value, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlGreaterThanOrEqualTo(Integer value) {
			addCriterion("zrl >=", value, "Zrl");
			return (Criteria) this;
		}
		public Criteria andZrlLessThan(Integer value) {
			addCriterion("zrl <", value, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlLessThanOrEqualTo(Integer value) {
			addCriterion("zrl <=", value, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlIn(List<Integer> values) {
			addCriterion("zrl in", values, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlNotIn(List<Integer> values) {
			addCriterion("zrl not in", values, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlBetween(Integer value1, Integer value2) {
			addCriterion("zrl between", value1, value2, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlNotBetween(Integer value1, Integer value2) {
			addCriterion("zrl not between", value1, value2, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlLike(Integer value) {
			addCriterion("zrl like", value, "zrl");
			return (Criteria) this;
		}
		public Criteria andZrlNotLike(Integer value) {
			addCriterion("zrl not like", value, "zrl");
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
