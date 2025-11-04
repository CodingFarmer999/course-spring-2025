package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.ResultBean;
import com.course.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	/**
	 * 登入頁
	 * @return
	 */
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	/**
	 * 轉導遊戲主頁
	 * @return
	 */
	@GetMapping("/game")
	public String initGame() {
		return "game";
	}
	
	/**
	 * 開始新遊戲，取得新的4位數字
	 * @param model
	 * @return
	 */
	@GetMapping("/newGame")
	public String newGame(Model model) {
		Long gameId = gameService.getAnswer();
		// 將ID提供給頁面，在猜數字時傳送當作識別ID
		model.addAttribute("gameId", gameId);
		return "game";
	}
	
	/**
	 * 猜答案
	 * @param gameId
	 * @param guessNumber
	 * @param model
	 * @return
	 */
	@GetMapping("/guess")
	public String guessAnswer(@RequestParam("gameId") Long gameId, @RequestParam("guessNum") String guessNumber, Model model) {
		gameService.checkAnswer(gameId, guessNumber);
		List<ResultBean> historyList = gameService.getHistory(gameId);
		model.addAttribute("gameHistory", historyList);
		model.addAttribute("gameId", gameId);
		return "game";
	}
	
	@GetMapping("/admin/history")
	public String historyPage() {
		return "history";
	}
	
	/** 測試在 Controller 取得驗證資料 */
//	@GetMapping("/info")
//	public String getInfo(@AuthenticationPrincipal GameUserPrincipal principal) {
//		System.out.println("Username: " + principal.getUsersEntity().getUsername());
//		System.out.println("Role: " + principal.getUsersEntity().getRole());
//		return "game";
//	}
	
	@GetMapping("/info")
	public String getInfo(Authentication authentication) {
		System.out.println("Username: " + authentication.getName());
		System.out.println("Role: " + authentication.getAuthorities());
		return "game";
	}
	
}
