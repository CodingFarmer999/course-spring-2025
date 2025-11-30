package com.course.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.course.entity.BookEntity;
import com.course.model.BookVo;

@Service
public class BookServiceHelper {

	@Value("${upload.directory}")
	private String uploadDirectory;
	
	/**
	 * 寫入圖檔
	 * @param file
	 * @throws IOException
	 */
	public void saveImage(MultipartFile file) throws IOException {
		// 確保上傳目錄存在
		Path uploadPath = Paths.get(uploadDirectory);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		// 保存檔案
		Path filePath = uploadPath.resolve(file.getOriginalFilename());
		// 如果檔案已經存在，直接覆蓋舊檔
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public BookVo convertToVo(BookEntity entity) {
		BookVo vo = new BookVo();
		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setAuthor(entity.getAuthor());
		vo.setBuyDate(parseDateToString(entity.getBuyDate()));
		vo.setImgName(entity.getImgName());
		return vo;
	}
	
	public BookEntity convertToVo(BookVo book) {
		BookEntity entity = new BookEntity();
		entity.setId(book.getId());
		entity.setName(book.getName());
		entity.setAuthor(book.getAuthor());
		entity.setBuyDate(parseDate(book.getBuyDate()));
		
		String imgName = book.getFile().getOriginalFilename();
		if (!imgName.isBlank()) {
			entity.setImgName(imgName);
		}
		
		return entity;
	}
	
	/**
	 * 轉換日期
	 * @param dueDateStr
	 * @return
	 */
	public Date parseDate(String dueDateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dueDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public String parseDateToString(Date date) {
	    // 定義日期格式
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   // 將 Date 物件轉換為 String
	   return formatter.format(date);
	}
}
