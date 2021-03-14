package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
 
 public static int getRowCount(String path,String sheet) throws EncryptedDocumentException, FileNotFoundException, IOException {
  
  int rc =0;
  
  try {
   Workbook wb = WorkbookFactory.create(new FileInputStream(path));
   rc=wb.getSheet(sheet).getLastRowNum();
  }catch(Exception e){
   e.printStackTrace();
  }
  return rc; 
  
 }
 
 public static String getData(String path,String sheet,int r,int c) throws EncryptedDocumentException, FileNotFoundException, IOException {
  
  String v="";
  
  try {
   
   Workbook wb = WorkbookFactory.create(new FileInputStream(path));
   v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
  }catch(Exception e) {
   e.printStackTrace();
  }
  
  return v;
  
 }

}