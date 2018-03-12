package cyz.boot.test.file.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import cyz.boot.test.common.utils.LoggerUtil;

public class ExcelUtils {
	public static List<List<Object>> readExcelxls(String excelPath){
			List<List<Object>> excelList = new ArrayList<List<Object>>();
			File file = new File(excelPath);
			HSSFWorkbook hssfWorkbook = null;
			try{
			    POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));
			    hssfWorkbook=  new HSSFWorkbook(poifsFileSystem);
			    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			    int rowstart = hssfSheet.getFirstRowNum();
			    int rowEnd = hssfSheet.getLastRowNum();
			    for(int i=rowstart;i<=rowEnd;i++)
			    {
			        HSSFRow row = hssfSheet.getRow(i);
			        if(null == row) continue;
			        int cellStart = row.getFirstCellNum();
			        int cellEnd = row.getLastCellNum();
			
			        List<Object> cellList = new ArrayList<Object>(); 
			        for(int k=cellStart;k<=cellEnd;k++)
			        {
			            HSSFCell cell = row.getCell(k);
			            if(null==cell) continue;
			            //System.out.print("" + k + "  ");
			            //System.out.print("type:"+cell.getCellType());
			            switch (cell.getCellType())
			            {
			                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
			                	cellList.add(cell.getNumericCellValue());
			                    //LoggerUtil.info(cell.getNumericCellValue()+ "   ");
			                    break;
			                case HSSFCell.CELL_TYPE_STRING: // 字符串
			                	cellList.add(cell.getStringCellValue());
			                    break;
			                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
			                	cellList.add(cell.getBooleanCellValue());
			                    break;
			                case HSSFCell.CELL_TYPE_FORMULA: // 公式
			                	cellList.add(cell.getCellFormula());
			                    break;
			                case HSSFCell.CELL_TYPE_BLANK: // 空值
			                	cellList.add("");
			                    break;
			                case HSSFCell.CELL_TYPE_ERROR: // 故障
			                	cellList.add("");
			                    break;
			                default:
			                	cellList.add("未知类型");
			                    break;
			            }
			
			        }
			        excelList.add(cellList);
			    }
			}
			catch(Exception e){
				LoggerUtil.error("read "+excelPath+" excel error:"+e);
			}finally{
				try {
					if(hssfWorkbook!=null){
						hssfWorkbook.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return excelList;
	}
	public static List<List<Object>> readExcelxlsx(String excelPath){
		List<List<Object>> excelList = new ArrayList<List<Object>>();
		File file = new File(excelPath);
		XSSFWorkbook xssfWorkbook = null;
		try{
			xssfWorkbook = new XSSFWorkbook(file);
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

			int rowstart = xssfSheet.getFirstRowNum();
			int rowEnd = xssfSheet.getLastRowNum();
		    for(int i=rowstart;i<=rowEnd;i++)
		    {
		        XSSFRow row = xssfSheet.getRow(i);
		        if(null == row) continue;
		        int cellStart = row.getFirstCellNum();
		        int cellEnd = row.getLastCellNum();
		        List<Object> cellList = new ArrayList<Object>(); 
		        for(int k=cellStart;k<=cellEnd;k++)
		        {
		            XSSFCell cell = row.getCell(k);
		            if(null==cell) continue;
		
		            switch (cell.getCellType())
		            {
		                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
		                	cellList.add(cell.getNumericCellValue());
		                    break;
		                case HSSFCell.CELL_TYPE_STRING: // 字符串
		                	cellList.add(cell.getStringCellValue());
		                    break;
		                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
		                	cellList.add(cell.getBooleanCellValue());
		                    break;
		                case HSSFCell.CELL_TYPE_FORMULA: // 公式
		                	cellList.add(cell.getCellFormula());
		                    break;
		                case HSSFCell.CELL_TYPE_BLANK: // 空值
		                	cellList.add(" ");
		                    break;
		                case HSSFCell.CELL_TYPE_ERROR: // 故障
		                	cellList.add(" ");
		                    break;
		                default:
		                	cellList.add("未知类型   ");
		                    break;
		            }
		
		        }
		        excelList.add(cellList);
		    }
		    
		}catch(Exception e){
			LoggerUtil.error("read "+excelPath+" excel error:"+e);
		}finally{
			if(xssfWorkbook!=null){
				try {
					xssfWorkbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return excelList;
	}
	
	public static void writeExcelxls(String sheetName,String filePath,List<List<Object>> excelContent){
		if(!CollectionUtils.isEmpty(excelContent)){
		}else{
			LoggerUtil.error("write Excel error excelContent:"+excelContent);
			LoggerUtil.error("write Excel error fileName:"+filePath);
			return;
		}
		HSSFWorkbook workbook = null;
	    workbook = new HSSFWorkbook();
	    List<Object> headRowList = null;
	    //获取参数个数作为excel列数
	    headRowList = excelContent.get(0);
	    int columeCount = headRowList.size();
	    HSSFSheet sheet = workbook.createSheet(sheetName);
	    //创建第一栏
	    int index = 0;
	    //写入数据
	    for(List<Object> cellList : excelContent)
	    {
	        //logger.info("写入一行");
	        HSSFRow row = sheet.createRow(index);
	        for(int n=0;n<=columeCount-1;n++){
	            row.createCell(n);
	            row.getCell(n).setCellValue(String.valueOf(cellList.get(n)));
	        }
	        index++;
	    }

	    //写到磁盘上
	    try {
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
	        workbook.write(fileOutputStream);
	        fileOutputStream.close();
	        workbook.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public static void writeExcelxlsx(String sheetName,String filePath,List<List<Object>> excelContent){
		if(!CollectionUtils.isEmpty(excelContent)){
		}else{
			LoggerUtil.error("write Excel error excelContent:"+excelContent);
			LoggerUtil.error("write Excel error fileName:"+filePath);
			return;
		}
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook();
		List<Object> headRowList = null;
		//获取参数个数作为excel列数
		headRowList = excelContent.get(0);
		int columeCount = headRowList.size();
		XSSFSheet sheet = workbook.createSheet(sheetName);
		//创建第一栏
		int index = 0;
		//写入数据
		for(List<Object> cellList : excelContent)
		{
			//logger.info("写入一行");
			XSSFRow row = sheet.createRow(index);
			for(int n=0;n<=columeCount-1;n++){
				row.createCell(n);
				row.getCell(n).setCellValue(String.valueOf(cellList.get(n)));
			}
			index++;
		}
		
		//写到磁盘上
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			LoggerUtil.error("read file fail:{}", e);
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtil.error("read file fail:{}", e);
		}
		LoggerUtil.info("write excel success:{}", filePath);
	}
	
//	public static void main(String[] args) {
//		List<List<Object>> list = ExcelUtils.readExcelxlsx("D:\\11.xlsx");
//		LoggerUtil.info("list info:{}",list.toString());
//		ExcelUtils.writeExcelxlsx("firts sheet", "D:\\22.xlsx", list);
//		//		LoggerUtil.info(ExcelUtils.readExcelxls("D:\\11.xlsx").toString());
//	}
	
}
