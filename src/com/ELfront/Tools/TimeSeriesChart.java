package com.ELfront.Tools;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.ELfront.Constant.ConClass;

public class TimeSeriesChart {
  public ChartPanel getframe() {
	  
    StandardChartTheme mChartTheme = new StandardChartTheme("CN");
    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
    ChartFactory.setChartTheme(mChartTheme);		
    CategoryDataset mDataset = GetDataset();
    JFreeChart mChart = ChartFactory.createLineChart(
        "折线图",//图名字
        "日期",//横坐标
        "数量",//纵坐标
        mDataset,//数据集
        PlotOrientation.VERTICAL,
        true, // 显示图例
        true, // 采用标准生成器 
        false);// 是否生成超链接
    
    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
    mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
    mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
    mPlot.setOutlinePaint(Color.RED);//边界线
    
    ChartPanel mChartFrame = new ChartPanel(mChart);
//    mChartFrame.pack();

    return mChartFrame;

  }
  public static CategoryDataset GetDataset()
  {
    DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
    mDataset.setValue(ConClass.getStudy().getMon(), "学习", "星期一");
    mDataset.setValue(ConClass.getStudy().getTue(), "学习", "星期二");
    mDataset.setValue(ConClass.getStudy().getWed(), "学习", "星期三");
    mDataset.setValue(ConClass.getStudy().getThu(), "学习", "星期四");
    mDataset.setValue(ConClass.getStudy().getFri(), "学习", "星期五");
    mDataset.setValue(ConClass.getStudy().getSat(), "学习", "星期六");
    mDataset.setValue(ConClass.getStudy().getSun(), "学习", "星期天");
    
    mDataset.setValue(ConClass.getRestudy().getMon(), "复习", "星期一");
    mDataset.setValue(ConClass.getRestudy().getTue(), "复习", "星期二");
    mDataset.setValue(ConClass.getRestudy().getWed(), "复习", "星期三");
    mDataset.setValue(ConClass.getRestudy().getThu(), "复习", "星期四");
    mDataset.setValue(ConClass.getRestudy().getFri(), "复习", "星期五");
    mDataset.setValue(ConClass.getRestudy().getSat(), "复习", "星期六");
    mDataset.setValue(ConClass.getRestudy().getSun(), "复习", "星期天");
    
    return mDataset;
  }


}