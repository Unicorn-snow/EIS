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
       		               xy + "�ͳ�Ʊ�", // ͼ�����
                            "�Ƿ��", // Ŀ¼�����ʾ��ǩ
                            "����", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
        
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
          
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������
          
         chartPanel=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
         setContentPane(chartPanel);
 		 setVisible(true);
 		
         
         
	}
	   private  CategoryDataset getDataSet() {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           ChartDb ca = new ChartDb();
           int yCount = ca.getyCount(xy, cmp);
           int noCount = ca.getCount(xy, cmp) - yCount;
           dataset.addValue(yCount, xy, "���");
           
           dataset.addValue(noCount, xy, "δ�"); 
           
          
           return dataset;
}

}