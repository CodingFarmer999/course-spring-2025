package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.BookMapper;
import com.course.model.BookDto;
import com.course.model.BookVo;

@Service
public class BookService {

	Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	private BookMapper bookMapper;
	
	public List<BookDto> getAll() {
		// return bookMapper.findAll();
		return bookMapper.findAllData();
	}
	
	public List<BookDto> searchByName(String name) {
		return bookMapper.findByName("%" + name + "%");
	}
	
	public void addBook(BookVo vo) {
		BookDto dto = convertToDto(vo);
		Integer insertCnt = bookMapper.insert(dto);
		logger.info("insertCnt: {}", insertCnt);
	}
	
	public void updateAuthor(BookVo vo) {
		BookDto dto = new BookDto();
		dto.setId(vo.getId());
		dto.setAuthor(vo.getAuthor());
		Integer updateCnt = bookMapper.update(dto);
		
		logger.info("updateCnt: {}", updateCnt);
	}
	
	public void deleteBook(Long id) {
		Integer deleteCnt = bookMapper.deleteById(id);
		logger.info("deleteCnt: {}", deleteCnt);
	}
	
	public void insertAllData(BookVo vo) {
		BookDto dto = convertToDto(vo);
		bookMapper.insert(dto);
		bookMapper.insertInventory(dto);
	}
	
	public BookVo findById(Long id) {
		BookDto dto = bookMapper.findBookById(id);
		return convertToVo(dto);
	}

	private BookDto convertToDto(BookVo vo) {
		BookDto dto = new BookDto();
		dto.setId(vo.getId());
		dto.setAuthor(vo.getAuthor());
		dto.setName(vo.getName());
		dto.setBuyDate(parseDate(vo.getBuyDate()));
		dto.setImgName(vo.getImgName());
		dto.setStoreId(vo.getStoreId());
		dto.setQuantity(vo.getQuantity());
		return dto;
	}
	
	private BookVo convertToVo(BookDto dto) {
		BookVo vo = new BookVo();
		vo.setId(dto.getId());
		vo.setAuthor(dto.getAuthor());
		vo.setName(dto.getName());
		vo.setBuyDate(parseDateToString(dto.getBuyDate()));
		vo.setImgName(dto.getImgName());
		vo.setStoreId(dto.getStoreId());
		vo.setQuantity(dto.getQuantity());
		return vo;
	}
	
	/**
	 * 轉換日期
	 * @param dateStr
	 * @return
	 */
	public Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dateStr);
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
