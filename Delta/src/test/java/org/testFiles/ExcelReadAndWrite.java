package org.testFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAndWrite {
	private void writeExcell() throws IOException {
		File f = new File("New.xlsx");
		FileOutputStream ff = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet sh = w.createSheet("datas");
		Row row = sh.createRow(0);
		row.createCell(0).setCellValue("UserNames");
		row.createCell(1).setCellValue("Passwords");
		Row row2 = sh.createRow(1);
		row2.createCell(0).setCellValue("prakashpaiyya@gmail.com");
		row2.createCell(1).setCellValue("1234567890A");
		w.write(ff);
		w.close();
		ff.close();
		System.err.println("File Created successfully");
	}

	private void readExcell() throws IOException {
		File f = new File("New.xlsx");
		FileInputStream ff = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(ff);
		Sheet sheet = w.getSheet("datas");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		System.out.println(cell);
		Cell cell2 = row.getCell(1);
		System.out.println(cell2);

		if (cell.getStringCellValue().contains("prakashpaiyya@gmail.com")) {
			cell.setCellValue("test@gmail.com");
		} else {
			System.out.println("Which is not eqaul");
		}
		System.out.println("\"Writted\"");
		ff.close();
		FileOutputStream q = new FileOutputStream(f);
		w.write(q);
		w.close();
		q.close();
	}

	private void prop() throws IOException {
		File fb = new File("test.properties");
		FileOutputStream ff = new FileOutputStream(fb);
		Properties p = new Properties();
		// p.clear();
		p.setProperty("Email", "Test@gmail.com");
		p.setProperty("Password", "12345678");
		p.setProperty("Email1", "rk@gmail.com");
		p.setProperty("Password2", "A123@123");
		p.store(ff, "Test data Added");
		ff.close();
		System.out.println("Test Data added");
	}

	private void getData() throws IOException {
		File f = new File("test.properties");
		FileInputStream ff = new FileInputStream(f);
		Properties p = new Properties();
		p.load(ff);
		String pro = p.getProperty("Email");
		System.out.println("Email ID :" + pro);
		String pass = p.getProperty("Password");
		System.out.println("Password ID :" + pass);
		String pro1 = p.getProperty("Email1");
		System.out.println("Email ID2 :" + pro1);
		String pass2 = p.getProperty("Password2");
		System.out.println("Password ID2 :" + pass2);
		ff.close();

	}

	public static void main(String[] args) throws IOException {
		ExcelReadAndWrite e = new ExcelReadAndWrite();
		e.getData();
	}

}
