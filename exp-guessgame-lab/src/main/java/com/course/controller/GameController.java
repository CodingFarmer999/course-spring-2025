package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/game")
	public String initGame() {
		return "game";
	}
	
	@GetMapping("/newGame")
	public String newGame(Model model) {
		Long gameId = gameService.getAnswer();
		// 將ID提供給頁面，在猜數字時傳送當作識別ID
		model.addAttribute("gameId", gameId);
		return "game";
	}
	
	@GetMapping("/guess")
	public String guessAnswer(@RequestParam("gameId") Long gameId, @RequestParam("guessNum") String guessNumber, Model model) {
		gameService.checkAnswer(gameId, guessNumber);
		List<ResultBean> historyList = gameService.getHistory(gameId);
		model.addAttribute("gameHistory", historyList);
		model.addAttribute("gameId", gameId);
		return "game";
	}
	
}
