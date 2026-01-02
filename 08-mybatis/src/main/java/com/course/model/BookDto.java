package com.course.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BookDto {

	private Long id;

	private String name;

	private String author;
	
	private Date buyDate;
	
	private String imgName;
	
	// TABLE: STORE 欄位
	private Long storeId;
	
	private String storeName;
	
	// TABLE: INVENTORY 欄位
	private Integer quantity;
	
	/** 庫存門店 */
	private List<String> inventoryStores;
	
	private List<StoreDto> stores;
}
