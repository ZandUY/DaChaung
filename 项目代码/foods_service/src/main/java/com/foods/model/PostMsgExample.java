package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class PostMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public PostMsgExample() {
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
		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}
		public Criteria andTitleIsNotNull(){
			addCriterion("title is not null");
			return (Criteria) this;
		}
		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "Title");
			return (Criteria) this;
		}
		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}
		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}
		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}
		public Criteria andSubtitleIsNull() {
			addCriterion("subtitle is null");
			return (Criteria) this;
		}
		public Criteria andSubtitleIsNotNull(){
			addCriterion("subtitle is not null");
			return (Criteria) this;
		}
		public Criteria andSubtitleEqualTo(String value) {
			addCriterion("subtitle =", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleNotEqualTo(String value) {
			addCriterion("subtitle <>", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleGreaterThan(String value) {
			addCriterion("subtitle >", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
			addCriterion("subtitle >=", value, "Subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleLessThan(String value) {
			addCriterion("subtitle <", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleLessThanOrEqualTo(String value) {
			addCriterion("subtitle <=", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleIn(List<String> values) {
			addCriterion("subtitle in", values, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleNotIn(List<String> values) {
			addCriterion("subtitle not in", values, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleBetween(String value1, String value2) {
			addCriterion("subtitle between", value1, value2, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleNotBetween(String value1, String value2) {
			addCriterion("subtitle not between", value1, value2, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleLike(String value) {
			addCriterion("subtitle like", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andSubtitleNotLike(String value) {
			addCriterion("subtitle not like", value, "subtitle");
			return (Criteria) this;
		}
		public Criteria andPostDetailIsNull() {
			addCriterion("post_detail is null");
			return (Criteria) this;
		}
		public Criteria andPostDetailIsNotNull(){
			addCriterion("post_detail is not null");
			return (Criteria) this;
		}
		public Criteria andPostDetailEqualTo(String value) {
			addCriterion("post_detail =", value, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailNotEqualTo(String value) {
			addCriterion("post_detail <>", value, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailGreaterThan(String value) {
			addCriterion("post_detail >", value, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailGreaterThanOrEqualTo(String value) {
			addCriterion("post_detail >=", value, "PostDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailLessThan(String value) {
			addCriterion("post_detail <", value, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailLessThanOrEqualTo(String value) {
			addCriterion("post_detail <=", value, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailIn(List<String> values) {
			addCriterion("post_detail in", values, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailNotIn(List<String> values) {
			addCriterion("post_detail not in", values, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailBetween(String value1, String value2) {
			addCriterion("post_detail between", value1, value2, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailNotBetween(String value1, String value2) {
			addCriterion("post_detail not between", value1, value2, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailLike(String value) {
			addCriterion("post_detail like", value, "postDetail");
			return (Criteria) this;
		}
		public Criteria andPostDetailNotLike(String value) {
			addCriterion("post_detail not like", value, "postDetail");
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
		public Criteria andFbTimeIsNull() {
			addCriterion("fb_time is null");
			return (Criteria) this;
		}
		public Criteria andFbTimeIsNotNull(){
			addCriterion("fb_time is not null");
			return (Criteria) this;
		}
		public Criteria andFbTimeEqualTo(String value) {
			addCriterion("fb_time =", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotEqualTo(String value) {
			addCriterion("fb_time <>", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeGreaterThan(String value) {
			addCriterion("fb_time >", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeGreaterThanOrEqualTo(String value) {
			addCriterion("fb_time >=", value, "FbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeLessThan(String value) {
			addCriterion("fb_time <", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeLessThanOrEqualTo(String value) {
			addCriterion("fb_time <=", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeIn(List<String> values) {
			addCriterion("fb_time in", values, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotIn(List<String> values) {
			addCriterion("fb_time not in", values, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeBetween(String value1, String value2) {
			addCriterion("fb_time between", value1, value2, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotBetween(String value1, String value2) {
			addCriterion("fb_time not between", value1, value2, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeLike(String value) {
			addCriterion("fb_time like", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotLike(String value) {
			addCriterion("fb_time not like", value, "fbTime");
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
