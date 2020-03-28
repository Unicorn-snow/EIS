package com.nwnu.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.nwnu.model.dao.InsertDb;
import com.nwnu.model.dao.LoginDb;

import java.util.Date;

public class Report extends JFrame{
	
	Report(){
		
		
		setSize(450,600);
		setLocationRelativeTo(null);
		
		
		 GridLayout layout = new GridLayout(12,2);
		 layout.setHgap(20);
	     layout.setVgap(10);
	     JPanel panel = new JPanel(layout);
	     
	     JLabel jLabel1 = new JLabel("上报日期");	
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    // nowdate = formatter.format(new Date());
	     JLabel text1 = new JLabel(formatter.format(new Date()));
	     
	     JLabel jLabel2 = new JLabel("姓名");
	     JTextField text2 = new JTextField(8);
	     
	     JLabel jLabel3 = new JLabel("所在省");
	     JTextField text3 = new JTextField(8);
	     
	     JLabel jLabel4 = new JLabel("所在市");
	     JTextField text4 = new JTextField(8);
	     
	     JLabel jLabel5 = new JLabel("所在区");
	     JTextField text5 = new JTextField(8);
	     
	     String[] listData = new String[]{"是", "否"};

	     
	     JLabel jLabel6 = new JLabel("是否为武汉籍");
	     final JComboBox<String> comboBox6 = new JComboBox<String>(listData);
	     
	     JLabel jLabel7 = new JLabel("是否为湖北籍");
	     final JComboBox<String> comboBox7 = new JComboBox<String>(listData);
	     
	     JLabel jLabel8 = new JLabel("是否近14日内与疫区人员接触");
	     final JComboBox<String> comboBox8 = new JComboBox<String>(listData);
	     
	     JLabel jLabel9 = new JLabel("是否在武汉");
	     final JComboBox<String> comboBox9 = new JComboBox<String>(listData);
	     
	     JLabel jLabel10 = new JLabel("是否在湖北");
	     final JComboBox<String> comboBox10 = new JComboBox<String>(listData);
	     
	     JLabel jLabel11 = new JLabel("是否有疑似症状");
	     final JComboBox<String> comboBox11 = new JComboBox<String>(listData);
	     
	     JLabel jLabel12 = new JLabel("是否已经确认被感染");
	     final JComboBox<String> comboBox12 = new JComboBox<String>(listData);
	     
	     
	     //1
	    // c = new GridBagConstraints();
	    // gridBag.addLayoutComponent(jLabel1, c);
	   /*  
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(text1, c);
	     //2
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel2, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(text2, c);
	     //3
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel3, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(text3, c);
	     
	     //4
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel4, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(text4, c);
	     //5
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel5, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(text5, c);
	     //6
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel6, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox6, c);
	     //7
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel7, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox7, c);
	     //8
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel8, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox8, c);
	     //9
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel9, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox9, c);
	     
	     //10
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel10, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox10, c);
	     
	     //11
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel11, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox11, c);
	     
	     //12
	     c = new GridBagConstraints();
	     gridBag.addLayoutComponent(jLabel12, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(comboBox12, c);
	     */
	     
	     panel.add(jLabel1);
	     panel.add(text1);
	     panel.add(jLabel2);
	     panel.add(text2);
	     panel.add(jLabel3);
	     panel.add(text3);
	     panel.add(jLabel4);
	     panel.add(text4);
	     panel.add(jLabel5);
	     panel.add(text5);
	     panel.add(jLabel6);
	     panel.add(comboBox6);
	     panel.add(jLabel7);
	     panel.add(comboBox7);
	     panel.add(jLabel8);
	     panel.add(comboBox8);
	     panel.add(jLabel9);
	     panel.add(comboBox9);
	     panel.add(jLabel10);
	     panel.add(comboBox10);
	     panel.add(jLabel11);
	     panel.add(comboBox11);
	     panel.add(jLabel12);
	     panel.add(comboBox12);
	     
	     JButton submit = new JButton("提交");
	  //   c = new GridBagConstraints();
	  //   c.gridwidth = GridBagConstraints.REMAINDER;
	  //   c.fill = GridBagConstraints.BOTH;
	    // gridBag.addLayoutComponent(submit, c);
	     
	     submit.addActionListener(new ActionListener() {
	    	 
	    	 			
			@Override
			public void actionPerformed(ActionEvent e) {
				//String tString = comboBox12.getSelectedItem().toString();
				//System.out.println(tString);
				// TODO Auto-generated method stub
				String sub = "insert into information values('" + text1.getText()  + "','" + text2.getText() + "','" + text3.getText() + "','" +
				text4.getText() + "','" + text5.getText() + "','" + comboBox6.getSelectedItem().toString()  + "','"
				+ comboBox7.getSelectedItem().toString() + "','" + comboBox8.getSelectedItem().toString()
				 + "','" + comboBox9.getSelectedItem().toString() + "','" + comboBox10.getSelectedItem().toString() + "','" +
				 comboBox11.getSelectedItem().toString() + "','" + comboBox12.getSelectedItem().toString() + "')";
				InsertDb insertDb = new InsertDb();
				boolean req = insertDb.doInsert(sub);
				if(req)
				{
					JOptionPane.showMessageDialog(new JFrame(), "提交成功，即将退出", "Tip", JOptionPane.INFORMATION_MESSAGE);
					dispose(); //释放登录界面
					
					//new Report();
				}
				else 					
					JOptionPane.showMessageDialog(new JFrame(), "提交失败", "Tip", JOptionPane.INFORMATION_MESSAGE);	
								
			}
		});
	    JPanel panel2 = new JPanel();
	    panel2.add(submit);
	    
	    /* 
	    Box vBox = Box.createVerticalBox();
	    vBox.add(Box.createVerticalGlue());
	    vBox.add(Box.createHorizontalGlue());
	    vBox.add(panel);
	    vBox.add(panel2);
	     
	     */
	    GridBagLayout gridBag = new GridBagLayout();    // 布局管理器
	     GridBagConstraints c = null;                    // 约束
	    JPanel panelz = new JPanel(gridBag);
	    
	    c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(panel, c);
	     
	     c = new GridBagConstraints();
	     c.gridwidth = GridBagConstraints.REMAINDER;
	     c.fill = GridBagConstraints.BOTH;
	     gridBag.addLayoutComponent(panel2, c);
	     
	     panelz.add(panel);
	     panelz.add(panel2);
	     
	    
       
        setContentPane(panelz);
        setVisible(true); 

		
		
		
	}
}
