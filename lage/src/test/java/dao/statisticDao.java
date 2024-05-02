package dao;

import java.util.List;

import metier.statistic;

public interface statisticDao {
	
	public statistic save(statistic  M);
	public List<statistic > selectstatistic();
	void save();

}
