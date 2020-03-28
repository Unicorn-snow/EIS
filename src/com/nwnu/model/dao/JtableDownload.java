package com.nwnu.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class JtableDownload {   

    JTable table;   
    FileOutputStream fos;
    JFileChooser jfc = new JFileChooser();   

    public static  boolean flag;

    public JtableDownload(JTable table) {
        this.table = table;   
  

        jfc.setSelectedFile(new File(""));  
        int result= jfc.showSaveDialog(null);
        File file = jfc.getSelectedFile();
        try { 
            if (result == JFileChooser.APPROVE_OPTION) {
                this.fos = new FileOutputStream(file + ".xls"); 
                flag=true;
            } else {
                flag=false;
                JOptionPane.showMessageDialog(null,"您取消了下载!");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "已存在文件名相同的文件，要替换请先关闭！");
        } 
    }   

    public void export() {   
        HSSFWorkbook wb = new HSSFWorkbook();   
        HSSFSheet hs = wb.createSheet();   
        TableModel tm = table.getModel();   
        int row = tm.getRowCount();   
        System.out.println(row);
        int cloumn = tm.getColumnCount(); 
        System.out.println(cloumn);
        String te = table.getColumnName(0);
        System.out.println(te);
        
        //样式设计
        HSSFCellStyle style = wb.createCellStyle();   
        style.setAlignment(HorizontalAlignment.CENTER); // 居中
        HSSFFont font = wb.createFont();   
        font.setFontHeightInPoints((short) 11);   
        style.setFont(font);   

        for (int j = 0; j < cloumn; j++) {
            hs.setColumnWidth( j, (1 * 4000));   //设置列宽
        }
        
        HSSFCellStyle style1 = wb.createCellStyle();   
        style1.setAlignment(HorizontalAlignment.CENTER); // 表头居中
        HSSFFont font1 = wb.createFont();   
        font1.setFontHeightInPoints((short) 15);   
        //font1.setBoldweight((short) 700);   
        style1.setFont(font1);   

        //写入HSSF对象
        for (int i = 0; i < row + 1; i++) {   
            HSSFRow hr = hs.createRow(i);   
            for (int j = 0; j < cloumn; j++) {   
                if (i == 0) {   
                    String value = table.getColumnName(j);  
                    System.out.println(value);
                   // HSSFRichTextString srts = new HSSFRichTextString(value);   
                    HSSFCell hc = hr.createCell(j);   
                    hc.setCellStyle(style);   
                    hc.setCellValue(value);   
                } 
                else {   
                    if (tm.getValueAt(i - 1, j) != null) {   
                        String value = tm.getValueAt(i - 1, j).toString();   
                        HSSFRichTextString srts = new HSSFRichTextString(value);   
                        HSSFCell hc = hr.createCell((short) j);   
                        hc.setCellStyle(style);   
                        if (value.equals("") || value == null) {   
                            hc.setCellValue(new HSSFRichTextString(""));   
                        } else {   
                            hc.setCellValue(srts);   
                        }   
                    }   
                }   
            }   
        }   
       
        try {   
            wb.write(fos);   
            fos.close();  
            JOptionPane.showMessageDialog(null,"下载完成");
        } catch (IOException ex) {  

        }   
    }   
} 
