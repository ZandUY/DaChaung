package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class DisMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public DisMsgExample() {
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
		public Criteria andPostIdIsNull() {
			addCriterion("post_id is null");
			return (Criteria) this;
		}
		public Criteria andPostIdIsNotNull(){
			addCriterion("post_id is not null");
			return (Criteria) this;
		}
		public Criteria andPostIdEqualTo(Integer value) {
			addCriterion("post_id =", value, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdNotEqualTo(Integer value) {
			addCriterion("post_id <>", value, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdGreaterThan(Integer value) {
			addCriterion("post_id >", value, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_id >=", value, "PostId");
			return (Criteria) this;
		}
		public Criteria andPostIdLessThan(Integer value) {
			addCriterion("post_id <", value, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdLessThanOrEqualTo(Integer value) {
			addCriterion("post_id <=", value, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdIn(List<Integer> values) {
			addCriterion("post_id in", values, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdNotIn(List<Integer> values) {
			addCriterion("post_id not in", values, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdBetween(Integer value1, Integer value2) {
			addCriterion("post_id between", value1, value2, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
			addCriterion("post_id not between", value1, value2, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdLike(Integer value) {
			addCriterion("post_id like", value, "postId");
			return (Criteria) this;
		}
		public Criteria andPostIdNotLike(Integer value) {
			addCriterion("post_id not like", value, "postId");
			return (Criteria) this;
		}
		public Criteria andDisContentIsNull() {
			addCriterion("dis_content is null");
			return (Criteria) this;
		}
		public Criteria andDisContentIsNotNull(){
			addCriterion("dis_content is not null");
			return (Criteria) this;
		}
		public Criteria andDisContentEqualTo(String value) {
			addCriterion("dis_content =", value, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentNotEqualTo(String value) {
			addCriterion("dis_content <>", value, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentGreaterThan(String value) {
			addCriterion("dis_content >", value, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentGreaterThanOrEqualTo(String value) {
			addCriterion("dis_content >=", value, "DisContent");
			return (Criteria) this;
		}
		public Criteria andDisContentLessThan(String value) {
			addCriterion("dis_content <", value, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentLessThanOrEqualTo(String value) {
			addCriterion("dis_content <=", value, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentIn(List<String> values) {
			addCriterion("dis_content in", values, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentNotIn(List<String> values) {
			addCriterion("dis_content not in", values, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentBetween(String value1, String value2) {
			addCriterion("dis_content between", value1, value2, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentNotBetween(String value1, String value2) {
			addCriterion("dis_content not between", value1, value2, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentLike(String value) {
			addCriterion("dis_content like", value, "disContent");
			return (Criteria) this;
		}
		public Criteria andDisContentNotLike(String value) {
			addCriterion("dis_content not like", value, "disContent");
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
		public Criteria andDisTimeIsNull() {
			addCriterion("dis_time is null");
			return (Criteria) this;
		}
		public Criteria andDisTimeIsNotNull(){
			addCriterion("dis_time is not null");
			return (Criteria) this;
		}
		public Criteria andDisTimeEqualTo(String value) {
			addCriterion("dis_time =", value, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeNotEqualTo(String value) {
			addCriterion("dis_time <>", value, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeGreaterThan(String value) {
			addCriterion("dis_time >", value, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeGreaterThanOrEqualTo(String value) {
			addCriterion("dis_time >=", value, "DisTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeLessThan(String value) {
			addCriterion("dis_time <", value, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeLessThanOrEqualTo(String value) {
			addCriterion("dis_time <=", value, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeIn(List<String> values) {
			addCriterion("dis_time in", values, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeNotIn(List<String> values) {
			addCriterion("dis_time not in", values, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeBetween(String value1, String value2) {
			addCriterion("dis_time between", value1, value2, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeNotBetween(String value1, String value2) {
			addCriterion("dis_time not between", value1, value2, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeLike(String value) {
			addCriterion("dis_time like", value, "disTime");
			return (Criteria) this;
		}
		public Criteria andDisTimeNotLike(String value) {
			addCriterion("dis_time not like", value, "disTime");
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
