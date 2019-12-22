//package com.zxcv.commom.utils;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Enumeration;
//
//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipFile;
//import org.apache.tools.zip.ZipOutputStream;
//
///**
// * 采用ant.jar 包下的zip压缩解压.<br/>
// * 描述:JDK的zip 报：zip java.lang.IllegalArgumentException: MALFORMED 错误
// * 所以采用ant.jar 包下的zip
// *
// * @ClassName: ZIpUtil.java
// * @Description:
// * @version: v1.0.0
// * @author: wangfs
// * @date: 2017年7月3日   下午3:24:11
// * Modification History:
// * Date             Author          Version            Description
// *---------------------------------------------------------*
// * 2017年7月3日      wangfs           v1.0.0               创建
// */
//public class ZIpUtil {
//	/**
//	 * 功能：把 sourceDir 目录下的所有文件进行 zip 格式的压缩，保存为指定 zip 文件
//	 *
//	 * @param sourceDir
//	 * @param zipFile
//	 */
//
//	public static void zip(String sourceDir, String zipFile) {
//
//		OutputStream os = null;
//		BufferedOutputStream bos = null;
//
//		try {
//			os = new FileOutputStream(zipFile);
//
//			bos = new BufferedOutputStream(os);
//
//			ZipOutputStream zos = new ZipOutputStream(bos);
//
//			File file = new File(sourceDir);
//
//			String basePath = null;
//
//			if (file.isDirectory()) {
//
//				basePath = file.getPath();
//
//			} else {// 直接压缩单个文件时，取父目录
//
//				basePath = file.getParent();
//
//			}
//
//			zipFile(file, basePath, zos);
//
//			zos.closeEntry();
//
//			zos.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try{
//				if(os != null){
//					os.close();
//				}
//				if(bos != null){
//					bos.close();
//				}
//
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	/**
//	 * 功能：执行文件压缩成zip文件
//	 *
//	 * @param source
//	 * @param basePath
//	 *            待压缩文件根目录
//	 * @param zos
//	 */
//
//	private static void zipFile(File source, String basePath,ZipOutputStream zos) {
//
//		File[] files = new File[0];
//
//		if (source.isDirectory()) {
//
//			files = source.listFiles();
//
//		} else {
//
//			files = new File[1];
//
//			files[0] = source;
//
//		}
//
//		String pathName;// 存相对路径(相对于待压缩的根目录)
//
//		byte[] buf = new byte[1024];
//
//		int length = 0;
//
//		try {
//
//			for (File file : files) {
//
//				if (file.isDirectory()) {
//
//					pathName = file.getPath().substring(basePath.length() + 1)
//
//							+ "/";
//
//					zos.putNextEntry(new ZipEntry(pathName));
//
//					zipFile(file, basePath, zos);
//
//				} else {
//
//					pathName = file.getPath().substring(basePath.length() + 1);
//					InputStream is = null;
//					try {
//						is = new FileInputStream(file);
//
//						@SuppressWarnings("resource")
//						BufferedInputStream bis = new BufferedInputStream(is);
//
//						zos.putNextEntry(new ZipEntry(pathName));
//
//						while ((length = bis.read(buf)) > 0) {
//
//							zos.write(buf, 0, length);
//
//						}
//					} finally {
//						if (null != is) {
//							is.close();
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//   /**
//    * 解压zip.<br/>
//    * @param zipfile
//    * @param destDir
//    */
//	public static void unZip(String zipfile, String destDir) {
//		//destDir = destDir.endsWith("\\") ? destDir : destDir + "\\";
//		byte b[] = new byte[1024];
//		int length;
//		OutputStream outputStream  = null;
//		InputStream inputStream = null;
//		ZipFile zipFile = null;
//		try {
//			zipFile = new ZipFile(new File(zipfile), "GBK");
//			Enumeration<?> enumeration = zipFile.getEntries();
//			ZipEntry zipEntry = null;
//			while (enumeration.hasMoreElements()) {
//				zipEntry = (ZipEntry) enumeration.nextElement();
//				File loadFile = new File(destDir + zipEntry.getName());
//
//				if (zipEntry.isDirectory()) {
//					loadFile.mkdirs();
//				} else {
//					if (!loadFile.getParentFile().exists()) {
//						loadFile.getParentFile().mkdirs();
//					}
//					outputStream = new FileOutputStream(loadFile);
//					inputStream = zipFile.getInputStream(zipEntry);
//					while ((length = inputStream.read(b)) > 0)
//						outputStream.write(b, 0, length);
//				}
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//
//		} finally {
//			try{
//				if(outputStream != null ){
//					outputStream.close();
//				}
//				if(inputStream != null ){
//					inputStream.close();
//				}
//				if(zipFile != null){
//					zipFile.close();
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//}
