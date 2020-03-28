package com.nwnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.formula.functions.IfFunc;

import com.mysql.jdbc.JDBC4LoadBalancedMySQLConnection;
import com.nwnu.model.dao.JtableDownload;
import com.nwnu.model.dao.ManageDb;
import com.nwnu.model.dao.Query;
import com.nwnu.model.dao.QueryNew;

public class Managez extends JFrame{
	DefaultTableModel update_table;  
    JTable table;  
    QueryNew query;  
    JButton button;  
    Object a[][];  
    String b[];  
    
    Managez(){  
    	
     
    	JPanel panel = new JPanel(new BorderLayout());
    	
        query=new QueryNew();  
        query.setSqll("select * from information,basic where information.name = basic.name");
        a=query.getRecord();  
        b=query.getField();  
        update_table=new DefaultTableModel(a, b);  
        table=new JTable(update_table);
        JButton button2 = new JButton("高级查询");
        button=new JButton("导出");  
          
        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrollPane.setSize(1000,400);  
        table.setPreferredScrollableViewportSize(new Dimension(1000, 300)); 
        panel.add(scrollPane, BorderLayout.NORTH);  
        
        
       // panel.add(button2, BorderLayout.CENTER);
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchH();
				
			}
		});
          	
       
      //  panel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JtableDownload jtableDownload = new JtableDownload(table);
				jtableDownload.export();
			}
		});
        
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        
        JLabel xyJLabel = new JLabel("请选择需要统计的学院");
        String[] listData = new String[]{"文学院", "计算机学院"};
        final JComboBox<String> comboBox = new JComboBox<String>(listData);
        panel2.add(xyJLabel);
        panel2.add(comboBox);
        
        JLabel xyJLabel2 = new JLabel("请选择需要统计的信息");
        JRadioButton checkBox01 = new JRadioButton("已/未填报人员统计情况");
        JRadioButton checkBox02 = new JRadioButton("是否有疑似症状");
        JRadioButton checkBox03 = new JRadioButton("是否已经确认被感染");
		
		 // 创建按钮组，把两个单选按钮添加到该组
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(checkBox01);
        btnGroup.add(checkBox02);
        btnGroup.add(checkBox03);
        checkBox01.setSelected(true);
        
        panel2.add(xyJLabel2);
        panel2.add(checkBox01);
        panel2.add(checkBox02);
        panel2.add(checkBox03);
        
        
        JButton tJButton = new JButton("导出统计图");
        panel2.add(tJButton);
        tJButton.addActionListener(new ActionListener() {
        	int comp;
        	String xy ;
        	
        
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xy = comboBox.getSelectedItem().toString();
				if(checkBox01.isSelected()) {
					comp = 1;
				}
				else if(checkBox02.isSelected()) {
					comp = 2;
				}
				else 
					comp = 3;
				
				new BarChart(xy, comp);
				
				
				
				
			}
		});
        panel.add(panel2,BorderLayout.CENTER);
        
        
        
        
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 300, 10));
        
        panel3.add(button2);
        
        panel3.add(button);
        panel.add(panel3,BorderLayout.SOUTH);
		
        
        setContentPane(panel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }  
    
}
