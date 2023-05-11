package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "C:/sykim/source/09_Spring/ch19_bookupMember_sch/src/main/webapp/bookImgFileUpload/";
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}
	@Override
	public List<Book> bookList(String pageNum, Book book) { // book.schItem/book.schWord
		Paging paging = new Paging(bookDao.totCntBook(book), pageNum, 3, 3);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}
	@Override
	public int totCntBook(Book book) {
		return bookDao.totCntBook(book);
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}
	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = new String[2];
		int idx= 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				// 파일 업로드가 되고
				if(new File(uploadPath+bimg[idx]).exists()) {
					// 중복된 파일 이름이면
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}//if
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx])); // 서버에 저장
					System.out.println("서버파일 이름 : "+ uploadPath+bimg[idx]); 
					System.out.println("백업파일 이름 : " + backupPath+bimg[idx]); 
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공":idx+"번째 백업실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.registerBook(book);
	}
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = new String[2];
		int idx= 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				// 파일 업로드가 되고
				if(new File(uploadPath+bimg[idx]).exists()) {
					// 중복된 파일 이름이면
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}//if
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx])); // 서버에 저장
					System.out.println("서버파일 이름 : "+ uploadPath+bimg[idx]); 
					System.out.println("백업파일 이름 : " + backupPath+bimg[idx]); 
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공":idx+"번째 백업실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(book);
	}
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		File file = new File(serverFile);
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
