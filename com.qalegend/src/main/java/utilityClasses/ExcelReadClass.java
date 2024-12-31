package utilityClasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadClass {
	
		static FileInputStream f;
		static XSSFWorkbook w;
		static XSSFSheet s;
		public static String getStringdata(int a,int b) throws IOException
		
		{
			f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx");
			w=new XSSFWorkbook(f);
			s=w.getSheet("sheet1");
			Row r=s.getRow(a);//a=row
			Cell c = r.getCell(b);//b=col
			return c.getStringCellValue();
		}
		public static String getIntegerdata(int a,int b) throws IOException
		{
			f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx");
			w=new XSSFWorkbook(f);
			s=w.getSheet("sheet1");
			Row r=s.getRow(a);//a=row
			Cell c=r.getCell(b);//b=col
			int x=(int) c.getNumericCellValue();//read integer value from cell, type casting
			return String.valueOf(x);//read as string value, as we are giving through sendkeys and it accepts only string values...
			
		}

}
