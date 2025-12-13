package com.foods.controller;
import java.text.DecimalFormat;
import java.util.*;
public class ReferUtils {
	// 用户-物品评分矩阵
	private double[][] ratings;
	DecimalFormat df = new DecimalFormat("#.0");
	//    public ReferUtils(double[][] ratings) {
		//        this.ratings = ratings;
	//    }
	// 计算两个用户之间的相似度（余弦相似度）
	private double similarity(int user1, int user2) {
		double dotProduct = 0.0;  // 向量点乘结果
		double norm1 = 0.0;  // 向量1的模
		double norm2 = 0.0;  // 向量2的模
		for (int i = 0; i < ratings[user1].length; i++) {
			dotProduct += ratings[user1][i] * ratings[user2][i];
			norm1 += Math.pow(ratings[user1][i], 2);
			norm2 += Math.pow(ratings[user2][i], 2);
		}
		if (norm1 == 0 || norm2 == 0) {
			return 0.0;  // 避免除零错误
		} else {
			return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
		}
	}
	// 根据用户相似度进行推荐
	public List<Map<String,String>> recommend(Integer targetUid, int limitNum) {
		// 计算目标用户与其他用户的相似度
		//        Map<String, String> similarityMap = new HashMap<>();
		Integer uIndex = -1;
		for(int i=0;i<userList.size();i++) {
			Map<String,Object> map = userList.get(i);
			if(map.get("uid").toString().equals(targetUid+"")) {
				uIndex = i;
				break;
			}
		}
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for (int i = 0; i < ratings.length; i++) {
			if (i != uIndex) {
				double sim = similarity(uIndex, i);
				Map<String,String> map = new HashMap<String,String>();
				map.put("uid", userList.get(i).get("uid").toString());
				map.put("score", sim+"");
				list.add(map);
			}
		}
		Collections.sort(list, new Comparator<Map<String,String>>() {
			@Override
			public int compare(Map<String,String> entry1, Map<String,String> entry2) {
				Double score1 = Double.parseDouble(entry1.get("score"));
				Double score2 = Double.parseDouble(entry2.get("score"));
				return score2.compareTo(score1); // 从小到大排序
			}
		});
		List<Map<String,String>> rs = new ArrayList<Map<String,String>>();
		// 获取前N个最相似的用户的推荐列表
		List<Integer> recommendations = new ArrayList<>();
		int count = 0;
		for(Map<String,String> map:list) {
			Integer uid = Integer.parseInt(map.get("uid"));
			Double score = Double.parseDouble(map.get("score"));//用户相似度分数
			Integer uindex1 = -1;
			for(int i=0;i<userList.size();i++) {
				Map<String,Object> map2 = userList.get(i);
				if(map2.get("uid").toString().equals(uid+"")) {
					uindex1 = i;
					break;
				}
			}
			for (int i = 0; i < ratings[uindex1].length; i++) {
				if (ratings[uindex1][i] > 0 && ratings[uIndex][i] == 0) {
					Integer proId = proList.get(i);
					Double referScore = score*ratings[uindex1][i];//用户相似度分数*用户打分分数，等于推荐值
					boolean isIn = false;
					for(Map<String,String> map4:rs) {
						if(map4.get("proId").equals(proId+"")) {
							isIn=true;
						}
					}
					if(isIn==false) {
						Map<String,String> map5 = new HashMap<String,String>();
						map5.put("proId", proId+"");
						if(referScore==0.0) {
							map5.put("score", "0.0");
						}else {
							map5.put("score", df.format(referScore)+"");
						}
						rs.add(map5);
						count++;
						if (count >= limitNum) {
							break;
						}
					}
				}
			}
			if (count >= limitNum) {
				break;
			}
		}
		Collections.sort(rs, new Comparator<Map<String,String>>() {
			@Override
			public int compare(Map<String,String> entry1, Map<String,String> entry2) {
				Double score1 = Double.parseDouble(entry1.get("score"));
				Double score2 = Double.parseDouble(entry2.get("score"));
				return score2.compareTo(score1); // 从小到大排序
			}
		});
		if(rs.size()>limitNum) {
			rs = rs.subList(0, limitNum);
		}
		return rs;
	}
	//初始化单个用户的评分情况
	//uid表示用户id，proScoreList 表示评分记录，proList表示商品总数
	public Map<String,Object> initAScore(Integer uid,List<Map<String,String>> proScoreList,List<Integer> proList){
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,String>> scores = new ArrayList<Map<String,String>>();
		for(Integer p:proList) {
			double score = 0.0;
			for(Map<String,String> s:proScoreList) {
				Integer proId = Integer.parseInt(s.get("proId"));
				Double num = Double.parseDouble(s.get("score"));
				if(proId.equals(p)) {
					score = num;
					break;
				}
			}
			Map<String,String> map = new HashMap<String,String>();
			map.put("proId", p+"");
			map.put("score", score+"");
			scores.add(map);
		}
		rs.put("uid", uid);
		rs.put("scoreList", scores);
		return rs;
	}
	private List<Map<String,Object>> userList;
	private List<Integer> proList;
	//赋值用户的评分列表
	public void castToRatting(List<Map<String,Object>> userList,List<Integer> proList){
		double [][]rattings = new double[userList.size()][proList.size()];
		for(int i=0;i<userList.size();i++) {
			Map<String,Object> u = userList.get(i);
			List<Map<String,String>> scoreList = (List<Map<String, String>>) u.get("scoreList");
			for(int j=0;j<proList.size();j++) {
				Map<String,String> score  = scoreList.get(j);
				rattings[i][j] = Double.parseDouble(score.get("score"));
			}
		}
		this.ratings = rattings;
		this.userList = userList;
		this.proList = proList;
	}
	//获取推荐的结果
	public List<Map<String,String>> getReferList(Integer uid,Integer limitSize){
		List<Map<String,String>> list = recommend(uid, limitSize);
		return list;
	}
	//用户对产品的评分封装成map
	public Map<String,String> getScoreMap(Integer proId,Double score){
		Map<String,String> map = new HashMap<String,String>();
		map.put("proId", proId+"");
		map.put("score", score+"");
		return map;
	}
	public static void main(String[] args) {
		ReferUtils cf = new ReferUtils();
		List<Integer> proList = new ArrayList<Integer>();
		proList.add(1);
		proList.add(2);
		proList.add(3);
		proList.add(4);
		proList.add(5);//模拟添加5个景点
		List<Map<String,String>> uscore1  = new ArrayList<Map<String,String>>();
		uscore1.add(cf.getScoreMap(2,3.0));//用户1对产品2评分评3分
		uscore1.add(cf.getScoreMap(1,5.0));
		List<Map<String,String>> uscore2  = new ArrayList<Map<String,String>>();
		uscore2.add(cf.getScoreMap(4,3.0));//用户2对产品2评分评3分
		uscore2.add(cf.getScoreMap(1,4.0));
		List<Map<String,String>> uscore3  = new ArrayList<Map<String,String>>();
		uscore3.add(cf.getScoreMap(2,5.0));//用户3对产品2评分评3分
		uscore3.add(cf.getScoreMap(1,4.0));
		List<Map<String,Object>> ul = new ArrayList<Map<String,Object>>();//用户对各个产品的封装数据
		ul.add(cf.initAScore(1,uscore1,proList));
		ul.add(cf.initAScore(2,uscore2,proList));
		ul.add(cf.initAScore(3,uscore3,proList));
		cf.castToRatting(ul,proList);//传输封装后的数据到对象里
		List<Map<String,String>> rs =  cf.getReferList(1,3);//对于用户1，其他产品的推荐指数
		System.out.println("推荐物品： ");
	}
}
