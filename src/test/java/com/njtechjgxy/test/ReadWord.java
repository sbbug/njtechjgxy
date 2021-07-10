package com.njtechjgxy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


public class ReadWord {

	private static String path="F:/SCD.docx";
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XWPFDocument doc=null;
		try {
			doc = new XWPFDocument(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<XWPFTable> tables = doc.getTables();
		
		for(XWPFTable table : tables){
			 
			 for(XWPFTableRow row:table.getRows()){
				   
				 //if(i!=0 && i!=1){
					 for(XWPFTableCell cell:row.getTableCells()){
				         System.out.print(cell.getText()+"\t");
				//  }
			 }
				 System.out.println("");
			 }	
			 //i++;
		}   
	}

}
