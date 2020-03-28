package com.nwnu.view;

import java.awt.*;
import java.awt.event.*;  
import javax.swing.*; 
import javax.swing.table.DefaultTableModel;

import com.nwnu.model.dao.Query;
import com.nwnu.model.dao.Search;

public class SearchH extends JFrame implements ActionListener{
	Box box[],baseBox;  
    Query query;  
    JButton button;  
    JTextField field[]=null;  
    String a[]=null;  
    int n,mark,m;  
    Search search;  
    String tableName;  
    DefaultTableModel search_table;  
    Object object[][];  
    String b[];  
    
    public SearchH(){ 
    	
    	setSize(600,700);
    	
    	JPanel sp = new JPanel();
    	
        sp.setLayout(new FlowLayout());  
        query=new Query();    
        query.setTableName("information");  
        a=query.getField();  
        n=a.length;  
        box=new Box [n+1];  
        field =new JTextField[n];  
        for(int i=0;i<n;i++){  
            box[i]=Box.createHorizontalBox();  
            field[i]=new JTextField(10);  
            if(a[i].equals("Date")==true){  
                box[i].add(new JLabel("  "+a[i]));  
                box[i].add(Box.createHorizontalStrut(8));  
                box[i].add(field[i]);  
            }  
            else{  
                box[i].add(new JLabel("  "+a[i]));  
                box[i].add(Box.createHorizontalStrut(8));  
                box[i].add(field[i]);  
            }  
        }  
        object =new Object[0][0];  
        search_table=new DefaultTableModel(object, a);  
        JTable table=new JTable(search_table);  
        button=new JButton("����");  
        button.addActionListener(this);  
        box[n-1].add(new JLabel("  ��������"));  
        box[n-1].add(Box.createHorizontalStrut(8));  
        box[n-1].add(button);  
        baseBox=Box.createVerticalBox();  
        for(int i=0;i<n;i++){  
        baseBox.add(box[i]);  
        baseBox.add(Box.createVerticalStrut(8));  
        }  
        JScrollPane scrollPane=new JScrollPane(table);  
        scrollPane.setBounds(0,0,550,380);  
        table.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, scrollPane.getHeight()*2));  
        baseBox.add(scrollPane);   
        sp.add(baseBox);  
        table.revalidate();  
        
        
        
        setLocationRelativeTo(null);
        setContentPane(sp);
        setVisible(true);
          
    }  
    
    public void actionPerformed(ActionEvent e){  
        int i,sum=0;  
        for(i=0;i<n;i++){  
            if(field[i].getText().toString().equals("")==true)  
                sum++;  
        }  
        System.out.println(sum);  
        if(sum==n)  
            JOptionPane.showMessageDialog(this, "��δ�����κ�����,���������룡","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);  
        else{  
            Search search=new Search();  
            search.setTableName("information");  
            search.setField(field);  
            search.setA(a);  
            search.Execute_Search();      
            object=null;b=null;  
            query=new Query();  
            query.setTableName("sign");  
            object=search.getRecord();  
            search_table.setDataVector(object, a);  
        }  
    }  
}

