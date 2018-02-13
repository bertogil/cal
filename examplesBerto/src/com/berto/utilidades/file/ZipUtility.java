package com.berto.utilidades.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Utility class zipFiles or zipFolder.
 * 
 * @author berto Gil
 */

public class ZipUtility {

	private static final int BUFFER = 1024;
	private static List<String> filesListInFolder = new ArrayList<String>();
	private static final String FOLDER = "c:/Temp/tradexpress";
	private static final String FILE_1 = "C:/Temp/XMLENV/rutas_170208204510.xml";
	private static final String FILE_2 = "C:/Temp/VARIOS/DESADVD96A_GSI.RUN.TXT";

	public static void main(String[] args) throws IOException {

		ZipOutputStream zos = null;

		List<File> filesToAdd = new ArrayList<File>();
		filesToAdd.add(new File(FILE_1));
		filesToAdd.add(new File(FILE_2));

		addToZipFileFilesList(zos, filesToAdd, "c:/resultado.zip");

		// zipFolder(new File(FOLDER), "resultado.zip");
	}

	/**
	 * This method zips the directory
	 * 
	 * @param dir
	 * @param zipFolderName
	 */
	public static ZipOutputStream zipFolder(File dir, String zipFolderName) {
		ZipOutputStream zos = null;

		if (!filesListInFolder.isEmpty()) {
			filesListInFolder.clear();
		}

		try {
			getFilesInFolder(dir);
			FileOutputStream fos = new FileOutputStream(dir + "/" + zipFolderName);
			zos = new ZipOutputStream(fos);
			for (String filePath : filesListInFolder) {
				File fileAdd = new File(filePath);
				System.out.println(fileAdd.getName());
				ZipEntry ze = new ZipEntry(fileAdd.getName());
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[BUFFER];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Error zipFolder: " + e);
		}

		return zos;
	}

	/**
	 * This method zips the directory
	 * 
	 * @param dir
	 * @param zipFolderName
	 */
	public byte[] zipFolderBytes(File dir, String zipFolderName) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		if (!filesListInFolder.isEmpty()) {
			filesListInFolder.clear();
		}

		try {
			getFilesInFolder(dir);
			ZipOutputStream zos = new ZipOutputStream(bos);
			for (String filePath : filesListInFolder) {
				ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[BUFFER];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
		} catch (IOException e) {
			System.out.println("Error zipFolder: " + e);
		}
		return bos.toByteArray();
	}

	/**
	 * This method zips the directory with invoices
	 * 
	 * @param dir
	 * @param zipFolderName
	 */
	public byte[] zipFolderBytesInvoices(File dir, String invoice, String zipFolderName) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		if (!filesListInFolder.isEmpty()) {
			filesListInFolder.clear();
		}

		try {
			getFilesInFolder(dir);
			ZipOutputStream zos = new ZipOutputStream(bos);
			for (String filePath : filesListInFolder) {
				if (filePath.contains(invoice)) {
					ZipEntry ze = new ZipEntry(
							filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
					zos.putNextEntry(ze);
					FileInputStream fis = new FileInputStream(filePath);
					byte[] buffer = new byte[BUFFER];
					int len;
					while ((len = fis.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
					zos.closeEntry();
					fis.close();
				}
			}
			zos.close();
		} catch (IOException e) {
			System.out.println("Error zipFolder: " + e);
		}
		return bos.toByteArray();
	}

	/**
	 * This method get all the files in a directory to a List
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void getFilesInFolder(File dir) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				filesListInFolder.add(file.getAbsolutePath());
			} else {
				getFilesInFolder(file);
			}
		}
	}

	/**
	 * This method compresses the single file to zip format
	 * 
	 * @param file
	 * @param zipFileName
	 */
	public ZipOutputStream zipFile(File file, String zipFileName) {
		ZipOutputStream zos = null;
		try {
			FileOutputStream fos = new FileOutputStream(zipFileName);
			zos = new ZipOutputStream(fos);
			ZipEntry ze = new ZipEntry(file.getName());
			zos.putNextEntry(ze);
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[BUFFER];
			int len;
			while ((len = fis.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}

			zos.closeEntry();
			zos.close();
			fis.close();
			fos.close();
			System.out.println(file.getCanonicalPath() + " Compacting " + zipFileName);
		} catch (IOException e) {
			System.out.println("Error zipFile: " + e);
		}
		return zos;
	}

	/**
	 * This method compresses the file list to zip format
	 * 
	 * @param filesList
	 * @param zipFileName
	 * @throws IOException
	 */
	public byte[] zipFileList(List<File> filesList, String zipFileName) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		for (File file : filesList) {
			if (file.isFile()) {
				filesListInFolder.add(file.getAbsolutePath());
			} else {
				getFilesInFolder(file);
			}
		}
		try {
			ZipOutputStream zos = new ZipOutputStream(bos);
			for (String filePath : filesListInFolder) {
				File fileAdd = new File(filePath);
				ZipEntry ze = new ZipEntry(fileAdd.getName());
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[BUFFER];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
		} catch (IOException e) {
			System.out.println("Error zipFolder: " + e);
		}
		return bos.toByteArray();
	}

	/* Crea fichero zip en memoria añadiendo una lista de ficheros */
	public static byte[] addToZipFilesList(ZipOutputStream zos, List<File> filesList, String zipFileName) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		for (File file : filesList) {
			if (file.isFile()) {
				filesListInFolder.add(file.getAbsolutePath());
			} else {
				try {
					getFilesInFolder(file);
				} catch (IOException e) {
					System.out.print("Error getFiles: " + e);
				}
			}
		}
		try {
			zos = new ZipOutputStream(bos);
			for (String filePath : filesListInFolder) {
				File fileAdd = new File(filePath);
				ZipEntry ze = new ZipEntry(fileAdd.getName());
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[BUFFER];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
		} catch (IOException e) {
			System.out.println("Error zipFolder: " + e);
		}
		return bos.toByteArray();
	}


	/* Crea fichero zip en carpeta añadiendo una lista de ficheros */
	public static ZipOutputStream addToZipFileFilesList(ZipOutputStream zos, List<File> filesList, String zipFileName) {
		for (File file : filesList) {
			if (file.isFile()) {
				filesListInFolder.add(file.getAbsolutePath());
			} else {
				try {
					getFilesInFolder(file);
				} catch (IOException e) {
					System.out.print("Error getFiles: " + e);
				}
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream(zipFileName);
			zos = new ZipOutputStream(fos);
			for (String filePath : filesListInFolder) {
				File fileAdd = new File(filePath);
				ZipEntry ze = new ZipEntry(fileAdd.getName());
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[BUFFER];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
		} catch (IOException e) {
			System.out.println("Error zipFolder: " + e);
		}
		return zos;
	}

	public static void addToZipFile(ZipOutputStream zos, String fileAdd, String fileIntoZip) {
		FileInputStream fis = null;
		try {
			if (!new File(fileAdd).exists()) {
				System.out.println(" Not exist file :  " + fileAdd);
				return;
			}
			File file = new File(fileAdd);
			System.out.println(" Create file '" + fileAdd + "' to ZIP ");
			fis = new FileInputStream(file);
			ZipEntry zipEntry = new ZipEntry(fileIntoZip);
			zos.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
			zos.closeEntry();
			fis.close();

		} catch (FileNotFoundException e) {
			System.out.println("File no exit: " + e);
		} catch (IOException e) {
			System.out.println("Exception I/O:" + e);
		}
	}
}
