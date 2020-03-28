package com.nwnu.view;



import java.awt.Font;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.nwnu.model.dao.ChartDb;

public class BarChart extends JFrame{	
	String xy;
	int cmp;
	
	public  BarChart(String xy,int cmp){
		this.xy = xy;
		this.cmp = cmp;
				
		ChartPanel chartPanel;
		
		setSize(450,600);
		setLocationRelativeTo(null);
	
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		               xy + "填报统计表", // 图表标题
                            "是否填报", // 目录轴的显示标签
                            "人数", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         chartPanel=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         setContentPane(chartPanel);
 		 setVisible(true);
 		
         
         
	}
	   private  CategoryDataset getDataSet() {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           ChartDb ca = new ChartDb();
           int yCount = ca.getyCount(xy, cmp);
           int noCount = ca.getCount(xy, cmp) - yCount;
           dataset.addValue(yCount, xy, "已填报");
           
           dataset.addValue(noCount, xy, "未填报"); 
           
          
           return dataset;
}

}