package com.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

	/** 回應碼 */
	private String resposeCode;
	
	/** 訊息 */
	private String message;
	
	/** 資料物件 */
	private T data;
	
    // 成功回應 靜態工廠方法
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("200", "成功", data);
    }

    // 失敗回應 靜態工廠方法
    public static <T> ApiResponse<T> error(String code, String message) {
        return new ApiResponse<>(code, message, null);
    }
    
    // 失敗回應 靜態工廠方法
    public static <T> ApiResponse<T> error(String code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }
}
