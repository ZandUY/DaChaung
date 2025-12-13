package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class ReplyMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public ReplyMsgExample() {
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
		public Criteria andDisIdIsNull() {
			addCriterion("dis_id is null");
			return (Criteria) this;
		}
		public Criteria andDisIdIsNotNull(){
			addCriterion("dis_id is not null");
			return (Criteria) this;
		}
		public Criteria andDisIdEqualTo(Integer value) {
			addCriterion("dis_id =", value, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdNotEqualTo(Integer value) {
			addCriterion("dis_id <>", value, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdGreaterThan(Integer value) {
			addCriterion("dis_id >", value, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("dis_id >=", value, "DisId");
			return (Criteria) this;
		}
		public Criteria andDisIdLessThan(Integer value) {
			addCriterion("dis_id <", value, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdLessThanOrEqualTo(Integer value) {
			addCriterion("dis_id <=", value, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdIn(List<Integer> values) {
			addCriterion("dis_id in", values, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdNotIn(List<Integer> values) {
			addCriterion("dis_id not in", values, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdBetween(Integer value1, Integer value2) {
			addCriterion("dis_id between", value1, value2, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdNotBetween(Integer value1, Integer value2) {
			addCriterion("dis_id not between", value1, value2, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdLike(Integer value) {
			addCriterion("dis_id like", value, "disId");
			return (Criteria) this;
		}
		public Criteria andDisIdNotLike(Integer value) {
			addCriterion("dis_id not like", value, "disId");
			return (Criteria) this;
		}
		public Criteria andReplyContentIsNull() {
			addCriterion("reply_content is null");
			return (Criteria) this;
		}
		public Criteria andReplyContentIsNotNull(){
			addCriterion("reply_content is not null");
			return (Criteria) this;
		}
		public Criteria andReplyContentEqualTo(String value) {
			addCriterion("reply_content =", value, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentNotEqualTo(String value) {
			addCriterion("reply_content <>", value, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentGreaterThan(String value) {
			addCriterion("reply_content >", value, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
			addCriterion("reply_content >=", value, "ReplyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentLessThan(String value) {
			addCriterion("reply_content <", value, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentLessThanOrEqualTo(String value) {
			addCriterion("reply_content <=", value, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentIn(List<String> values) {
			addCriterion("reply_content in", values, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentNotIn(List<String> values) {
			addCriterion("reply_content not in", values, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentBetween(String value1, String value2) {
			addCriterion("reply_content between", value1, value2, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentNotBetween(String value1, String value2) {
			addCriterion("reply_content not between", value1, value2, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentLike(String value) {
			addCriterion("reply_content like", value, "replyContent");
			return (Criteria) this;
		}
		public Criteria andReplyContentNotLike(String value) {
			addCriterion("reply_content not like", value, "replyContent");
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
		public Criteria andReplyTimeIsNull() {
			addCriterion("reply_time is null");
			return (Criteria) this;
		}
		public Criteria andReplyTimeIsNotNull(){
			addCriterion("reply_time is not null");
			return (Criteria) this;
		}
		public Criteria andReplyTimeEqualTo(String value) {
			addCriterion("reply_time =", value, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeNotEqualTo(String value) {
			addCriterion("reply_time <>", value, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeGreaterThan(String value) {
			addCriterion("reply_time >", value, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeGreaterThanOrEqualTo(String value) {
			addCriterion("reply_time >=", value, "ReplyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeLessThan(String value) {
			addCriterion("reply_time <", value, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeLessThanOrEqualTo(String value) {
			addCriterion("reply_time <=", value, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeIn(List<String> values) {
			addCriterion("reply_time in", values, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeNotIn(List<String> values) {
			addCriterion("reply_time not in", values, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeBetween(String value1, String value2) {
			addCriterion("reply_time between", value1, value2, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeNotBetween(String value1, String value2) {
			addCriterion("reply_time not between", value1, value2, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeLike(String value) {
			addCriterion("reply_time like", value, "replyTime");
			return (Criteria) this;
		}
		public Criteria andReplyTimeNotLike(String value) {
			addCriterion("reply_time not like", value, "replyTime");
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
