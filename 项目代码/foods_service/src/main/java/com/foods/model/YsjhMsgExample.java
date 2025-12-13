package com.foods.model;
import java.util.ArrayList;
import java.util.List;
public class YsjhMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public YsjhMsgExample() {
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
		public Criteria andJhNameIsNull() {
			addCriterion("jh_name is null");
			return (Criteria) this;
		}
		public Criteria andJhNameIsNotNull(){
			addCriterion("jh_name is not null");
			return (Criteria) this;
		}
		public Criteria andJhNameEqualTo(String value) {
			addCriterion("jh_name =", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameNotEqualTo(String value) {
			addCriterion("jh_name <>", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameGreaterThan(String value) {
			addCriterion("jh_name >", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameGreaterThanOrEqualTo(String value) {
			addCriterion("jh_name >=", value, "JhName");
			return (Criteria) this;
		}
		public Criteria andJhNameLessThan(String value) {
			addCriterion("jh_name <", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameLessThanOrEqualTo(String value) {
			addCriterion("jh_name <=", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameIn(List<String> values) {
			addCriterion("jh_name in", values, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameNotIn(List<String> values) {
			addCriterion("jh_name not in", values, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameBetween(String value1, String value2) {
			addCriterion("jh_name between", value1, value2, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameNotBetween(String value1, String value2) {
			addCriterion("jh_name not between", value1, value2, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameLike(String value) {
			addCriterion("jh_name like", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andJhNameNotLike(String value) {
			addCriterion("jh_name not like", value, "jhName");
			return (Criteria) this;
		}
		public Criteria andFmImgIsNull() {
			addCriterion("fm_img is null");
			return (Criteria) this;
		}
		public Criteria andFmImgIsNotNull(){
			addCriterion("fm_img is not null");
			return (Criteria) this;
		}
		public Criteria andFmImgEqualTo(String value) {
			addCriterion("fm_img =", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotEqualTo(String value) {
			addCriterion("fm_img <>", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgGreaterThan(String value) {
			addCriterion("fm_img >", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgGreaterThanOrEqualTo(String value) {
			addCriterion("fm_img >=", value, "FmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgLessThan(String value) {
			addCriterion("fm_img <", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgLessThanOrEqualTo(String value) {
			addCriterion("fm_img <=", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgIn(List<String> values) {
			addCriterion("fm_img in", values, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotIn(List<String> values) {
			addCriterion("fm_img not in", values, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgBetween(String value1, String value2) {
			addCriterion("fm_img between", value1, value2, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotBetween(String value1, String value2) {
			addCriterion("fm_img not between", value1, value2, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgLike(String value) {
			addCriterion("fm_img like", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotLike(String value) {
			addCriterion("fm_img not like", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andBmifwIsNull() {
			addCriterion("bmifw is null");
			return (Criteria) this;
		}
		public Criteria andBmifwIsNotNull(){
			addCriterion("bmifw is not null");
			return (Criteria) this;
		}
		public Criteria andBmifwEqualTo(Integer value) {
			addCriterion("bmifw =", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwNotEqualTo(Integer value) {
			addCriterion("bmifw <>", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwGreaterThan(Integer value) {
			addCriterion("bmifw >", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwGreaterThanOrEqualTo(Integer value) {
			addCriterion("bmifw >=", value, "Bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwLessThan(Integer value) {
			addCriterion("bmifw <", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwLessThanOrEqualTo(Integer value) {
			addCriterion("bmifw <=", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwIn(List<Integer> values) {
			addCriterion("bmifw in", values, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwNotIn(List<Integer> values) {
			addCriterion("bmifw not in", values, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwBetween(Integer value1, Integer value2) {
			addCriterion("bmifw between", value1, value2, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwNotBetween(Integer value1, Integer value2) {
			addCriterion("bmifw not between", value1, value2, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwLike(Integer value) {
			addCriterion("bmifw like", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andBmifwNotLike(Integer value) {
			addCriterion("bmifw not like", value, "bmifw");
			return (Criteria) this;
		}
		public Criteria andYnumFwIsNull() {
			addCriterion("ynum_fw is null");
			return (Criteria) this;
		}
		public Criteria andYnumFwIsNotNull(){
			addCriterion("ynum_fw is not null");
			return (Criteria) this;
		}
		public Criteria andYnumFwEqualTo(Integer value) {
			addCriterion("ynum_fw =", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwNotEqualTo(Integer value) {
			addCriterion("ynum_fw <>", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwGreaterThan(Integer value) {
			addCriterion("ynum_fw >", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwGreaterThanOrEqualTo(Integer value) {
			addCriterion("ynum_fw >=", value, "YnumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwLessThan(Integer value) {
			addCriterion("ynum_fw <", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwLessThanOrEqualTo(Integer value) {
			addCriterion("ynum_fw <=", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwIn(List<Integer> values) {
			addCriterion("ynum_fw in", values, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwNotIn(List<Integer> values) {
			addCriterion("ynum_fw not in", values, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwBetween(Integer value1, Integer value2) {
			addCriterion("ynum_fw between", value1, value2, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwNotBetween(Integer value1, Integer value2) {
			addCriterion("ynum_fw not between", value1, value2, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwLike(Integer value) {
			addCriterion("ynum_fw like", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andYnumFwNotLike(Integer value) {
			addCriterion("ynum_fw not like", value, "ynumFw");
			return (Criteria) this;
		}
		public Criteria andJhDetailIsNull() {
			addCriterion("jh_detail is null");
			return (Criteria) this;
		}
		public Criteria andJhDetailIsNotNull(){
			addCriterion("jh_detail is not null");
			return (Criteria) this;
		}
		public Criteria andJhDetailEqualTo(String value) {
			addCriterion("jh_detail =", value, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailNotEqualTo(String value) {
			addCriterion("jh_detail <>", value, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailGreaterThan(String value) {
			addCriterion("jh_detail >", value, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailGreaterThanOrEqualTo(String value) {
			addCriterion("jh_detail >=", value, "JhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailLessThan(String value) {
			addCriterion("jh_detail <", value, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailLessThanOrEqualTo(String value) {
			addCriterion("jh_detail <=", value, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailIn(List<String> values) {
			addCriterion("jh_detail in", values, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailNotIn(List<String> values) {
			addCriterion("jh_detail not in", values, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailBetween(String value1, String value2) {
			addCriterion("jh_detail between", value1, value2, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailNotBetween(String value1, String value2) {
			addCriterion("jh_detail not between", value1, value2, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailLike(String value) {
			addCriterion("jh_detail like", value, "jhDetail");
			return (Criteria) this;
		}
		public Criteria andJhDetailNotLike(String value) {
			addCriterion("jh_detail not like", value, "jhDetail");
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
