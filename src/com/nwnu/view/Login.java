package com.nwnu.view;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.nwnu.model.dao.LoginDb;


public class Login extends JFrame{
	public Login() {
		
		//Toolkit kit = Toolkit.getDefaultToolkit();
		//Dimension screenSize = kit.getScreenSize();
		//int width = screenSize.width;
		//int height = screenSize.height;
		setSize(390, 550);	
		setLocationRelativeTo(null);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//Image img = new Inagelcon("icon.gif").getlmage();
		//setlconlnage(img);
		
		
		

		JPanel panel  = new JPanel(null);
		
		JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("/EIS/source/logo1.jpg"));
        logo.setText("LOGO");
        //logo.setText("LOGO");
        logo.setBounds(50,50 ,240 ,240);
        panel.add(logo);
		
		JRadioButton radioButton1 = new JRadioButton("用户登录");
		JRadioButton radioButton2 = new JRadioButton("负责人登录");	
		
		 // 创建按钮组，把两个单选按钮添加到该组
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioButton1);
        btnGroup.add(radioButton2);
        radioButton1.setBounds(50, 230, 100, 20);
        radioButton2.setBounds(200, 230, 100, 20);
        // 设置第一个单选按钮选中
        radioButton1.setSelected(true);

        panel.add(radioButton1);
        panel.add(radioButton2);
		
		JLabel usr = new JLabel();
		usr.setText("用户名");
		usr.setFont(new Font(null, Font.BOLD, 18));
		panel.add(usr);
		usr.setBounds(50, 280, 100, 30);
		JTextField usrr = new JTextField();
		usrr.setBounds(140, 280, 200, 30);
		panel.add(usrr);
		
		
		JLabel passwd = new JLabel("密码");
		passwd.setText("密码");
		passwd.setFont(new Font(null, Font.BOLD, 18));
		passwd.setBounds(60, 330, 100, 30);
		panel.add(passwd);
		
		JPasswordField passwdd = new JPasswordField();
		passwdd.setBounds(140, 330, 200, 30);
		panel.add(passwdd);

		JButton login = new JButton("登录");
		login.setBounds(140, 400, 100, 30);
		//匿名内部类实现控制
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String loString;
				boolean req;
				if(radioButton1.isSelected()) {
					loString = "select * from basic where ID ='"+ usrr.getText() +"' and 密码 = '"+ String.valueOf(passwdd.getPassword())+"'";
					LoginDb selectDb = new LoginDb();
					req = selectDb.doSelect(loString);
					if(req)
					{
						JOptionPane.showMessageDialog(new JFrame(), "登录成功", "Tip", JOptionPane.INFORMATION_MESSAGE);
						dispose(); //释放登录界面
						
						new Report();
					}
					else 
						
						JOptionPane.showMessageDialog(new JFrame(), "账户或密码错误", "Tip", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else //负责人
				{					
					loString = "select * from admin where permission = 1 and ID ='"
							+ usrr.getText() +"' and pwd='"+ String.valueOf(passwdd.getPassword())+"'";
					LoginDb selectDb = new LoginDb();
					req = selectDb.doSelect(loString);
					if(req) //学校负责人
					{
						JOptionPane.showMessageDialog(new JFrame(), "登录成功", "Tip", JOptionPane.INFORMATION_MESSAGE);
						dispose(); //释放登录界面
						
						new Managez();
					}
					else //学院负责人
					{ 
						//String xyString;
						loString = "select * from admin where permission = 2 and 所在学院 = '文学院' and ID = '"
								+ usrr.getText() +"' and pwd='"+ String.valueOf(passwdd.getPassword())+"'";
						req = selectDb.doSelect(loString);
						if(req)
						{
							JOptionPane.showMessageDialog(new JFrame(), "登录成功", "Tip", JOptionPane.INFORMATION_MESSAGE);
							dispose(); //释放登录界面							
							new ManageW();							
						}
						else						
							JOptionPane.showMessageDialog(new JFrame(), "账户或密码错误", "Tip", JOptionPane.INFORMATION_MESSAGE);
					}
				}	
				
				
			}
		});
		
		panel.add(login);
		setContentPane(panel);

	}
	

		
	
}