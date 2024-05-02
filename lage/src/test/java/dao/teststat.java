package dao;

import java.util.List;

import metier.statistic;

public class teststat {

	public static void main(String[] args) {

				statisticImpli stat = new statisticImpli();
				
				List<statistic> st =  stat.selectstatistic();
				System.out.println(st);

				for(statistic stati: st) {
					System.out.println(stati.toString());
					}
				


	}

}
