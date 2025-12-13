package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class LmsgSuggestMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public LmsgSuggestMsgExample() {
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
		public Criteria andLmsgContentIsNull() {
			addCriterion("lmsg_content is null");
			return (Criteria) this;
		}
		public Criteria andLmsgContentIsNotNull(){
			addCriterion("lmsg_content is not null");
			return (Criteria) this;
		}
		public Criteria andLmsgContentEqualTo(String value) {
			addCriterion("lmsg_content =", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentNotEqualTo(String value) {
			addCriterion("lmsg_content <>", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentGreaterThan(String value) {
			addCriterion("lmsg_content >", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentGreaterThanOrEqualTo(String value) {
			addCriterion("lmsg_content >=", value, "LmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentLessThan(String value) {
			addCriterion("lmsg_content <", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentLessThanOrEqualTo(String value) {
			addCriterion("lmsg_content <=", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentIn(List<String> values) {
			addCriterion("lmsg_content in", values, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentNotIn(List<String> values) {
			addCriterion("lmsg_content not in", values, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentBetween(String value1, String value2) {
			addCriterion("lmsg_content between", value1, value2, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentNotBetween(String value1, String value2) {
			addCriterion("lmsg_content not between", value1, value2, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentLike(String value) {
			addCriterion("lmsg_content like", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgContentNotLike(String value) {
			addCriterion("lmsg_content not like", value, "lmsgContent");
			return (Criteria) this;
		}
		public Criteria andLmsgImgIsNull() {
			addCriterion("lmsg_img is null");
			return (Criteria) this;
		}
		public Criteria andLmsgImgIsNotNull(){
			addCriterion("lmsg_img is not null");
			return (Criteria) this;
		}
		public Criteria andLmsgImgEqualTo(String value) {
			addCriterion("lmsg_img =", value, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgNotEqualTo(String value) {
			addCriterion("lmsg_img <>", value, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgGreaterThan(String value) {
			addCriterion("lmsg_img >", value, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgGreaterThanOrEqualTo(String value) {
			addCriterion("lmsg_img >=", value, "LmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgLessThan(String value) {
			addCriterion("lmsg_img <", value, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgLessThanOrEqualTo(String value) {
			addCriterion("lmsg_img <=", value, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgIn(List<String> values) {
			addCriterion("lmsg_img in", values, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgNotIn(List<String> values) {
			addCriterion("lmsg_img not in", values, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgBetween(String value1, String value2) {
			addCriterion("lmsg_img between", value1, value2, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgNotBetween(String value1, String value2) {
			addCriterion("lmsg_img not between", value1, value2, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgLike(String value) {
			addCriterion("lmsg_img like", value, "lmsgImg");
			return (Criteria) this;
		}
		public Criteria andLmsgImgNotLike(String value) {
			addCriterion("lmsg_img not like", value, "lmsgImg");
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
		public Criteria andLmsgStatusIsNull() {
			addCriterion("lmsg_status is null");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusIsNotNull(){
			addCriterion("lmsg_status is not null");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusEqualTo(Integer value) {
			addCriterion("lmsg_status =", value, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusNotEqualTo(Integer value) {
			addCriterion("lmsg_status <>", value, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusGreaterThan(Integer value) {
			addCriterion("lmsg_status >", value, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("lmsg_status >=", value, "LmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusLessThan(Integer value) {
			addCriterion("lmsg_status <", value, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusLessThanOrEqualTo(Integer value) {
			addCriterion("lmsg_status <=", value, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusIn(List<Integer> values) {
			addCriterion("lmsg_status in", values, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusNotIn(List<Integer> values) {
			addCriterion("lmsg_status not in", values, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusBetween(Integer value1, Integer value2) {
			addCriterion("lmsg_status between", value1, value2, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("lmsg_status not between", value1, value2, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusLike(Integer value) {
			addCriterion("lmsg_status like", value, "lmsgStatus");
			return (Criteria) this;
		}
		public Criteria andLmsgStatusNotLike(Integer value) {
			addCriterion("lmsg_status not like", value, "lmsgStatus");
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
		public Criteria andLmsgTimeIsNull() {
			addCriterion("lmsg_time is null");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeIsNotNull(){
			addCriterion("lmsg_time is not null");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeEqualTo(String value) {
			addCriterion("lmsg_time =", value, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeNotEqualTo(String value) {
			addCriterion("lmsg_time <>", value, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeGreaterThan(String value) {
			addCriterion("lmsg_time >", value, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeGreaterThanOrEqualTo(String value) {
			addCriterion("lmsg_time >=", value, "LmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeLessThan(String value) {
			addCriterion("lmsg_time <", value, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeLessThanOrEqualTo(String value) {
			addCriterion("lmsg_time <=", value, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeIn(List<String> values) {
			addCriterion("lmsg_time in", values, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeNotIn(List<String> values) {
			addCriterion("lmsg_time not in", values, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeBetween(String value1, String value2) {
			addCriterion("lmsg_time between", value1, value2, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeNotBetween(String value1, String value2) {
			addCriterion("lmsg_time not between", value1, value2, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeLike(String value) {
			addCriterion("lmsg_time like", value, "lmsgTime");
			return (Criteria) this;
		}
		public Criteria andLmsgTimeNotLike(String value) {
			addCriterion("lmsg_time not like", value, "lmsgTime");
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
