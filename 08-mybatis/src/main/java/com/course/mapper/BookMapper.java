package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.course.model.BookDto;

@Mapper
public interface BookMapper {
	
	@Select("SELECT * FROM BOOK")
	List<BookDto> findAll();
	
	@Select("SELECT B.NAME, S.NAME STORENAME, I.QUANTITY FROM BOOK B JOIN INVENTORY I ON I.BOOK_ID = B.ID JOIN STORE S ON S.ID = I.STORE_ID")
	List<BookDto> findAllData();
	
	@Select("SELECT * FROM BOOK WHERE NAME LIKE #{name}")
	List<BookDto> findByName(String name);
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("INSERT INTO BOOK (AUTHOR, NAME, BUY_DATE, IMG_NAME) VALUES (#{author}, #{name}, #{buyDate}, #{imgName})")
	Integer insert(BookDto book);
	
	@Update("UPDATE BOOK SET AUTHOR = #{author} WHERE ID = #{id}")
	Integer update(BookDto book);
	
	@Delete("DELETE FROM BOOK WHERE ID = #{id}")
	Integer deleteById(Long id);
	
	@Insert("INSERT INTO INVENTORY (STORE_ID, BOOK_ID, QUANTITY) VALUES (#{storeId}, #{id}, #{quantity})")
	Integer insertInventory(BookDto book);
	
	BookDto findBookById(Long id);
	
	List<BookDto> findAll2();
	
	List<BookDto> findAllInvetory();
	
	
}
