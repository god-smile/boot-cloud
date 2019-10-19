package com.zxcv.commom.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.csvreader.CsvReader;
/**
 * svc格式数据读取工具类.<br/>
 * 
 * Copyright: Copyright (c) 2017  zteits
 * 
 * @ClassName: CVSUtils.java
 * @Description: 
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2017年7月4日   上午9:45:36 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年7月4日      wangfs           v1.0.0               创建
 */
public class CSVUtils {

	/**
	 * 读取CVS文件.<br/>
	 * 
	 * @param filePath
	 *            文件路径.<br/>
	 * @param fileName
	 *            要读取的文件名.<br/>
	 * @param startRow
	 *            读取开始行数.<br/>
	 * @param endStr
	 *            结束字符串.<br/>
	 */
	public static List<String[]> csvRead(String filePath, String fileName, Long startRow, String endStr) {
		FileInputStream InputStream = null;
		List<String[]> list = new ArrayList<String[]>();
		Long readRow = 0L;

		try {
			if (!StringUtils.isEmpty(filePath) && !StringUtils.isEmpty(fileName)) {
				File file = new File(filePath);
				File[] files = file.listFiles();
				if(files.length >0){
					for(File f:files){
						String filesName = f.getName();
						if(filesName.contains(fileName)){
							InputStream =new FileInputStream(f);
						}
					}
				}
                if(InputStream !=null){
					CsvReader csvReader = new CsvReader(InputStream, Charset.forName("GBK"));
					while (csvReader.readRecord()) {
						if (csvReader.getCurrentRecord() >= startRow) {
							if (readRow == 0L) {
								// 读一整行
								String[] strArray = csvReader.getValues();
								if (strArray[0].contains(endStr)) {
									readRow = csvReader.getCurrentRecord();
									break;
								} else {
									list.add(strArray);
								}
							}
						}

					} // while
					csvReader.close();
				}
			} else {
				throw new NullPointerException("filePath and fileName Can not be empty!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(InputStream != null){
					InputStream.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;

	}
/**
	public static void main(String[] args) {
		List<String[]> list = CSVUtils.csvRead(
				"/Users/wangfs/Desktop/workspace/springsts/zteits-clouds/zteits-pay/doc/bill_zfb/",
				"a.txt", 1L, "总交易单数,总交易额,总退款金额");
		if (list != null && list.size() > 0) {
			for (String[] str : list) {
				for (String s : str) {
					System.out.print(s + ",");
				}
				System.out.println();
			}
		}
	}*/
}
