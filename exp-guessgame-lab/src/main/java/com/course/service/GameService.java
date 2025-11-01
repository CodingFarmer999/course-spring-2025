package com.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.course.entity.GameEntity;
import com.course.entity.GameHistoryEntity;
import com.course.model.ResultBean;
import com.course.repository.GameHistoryRepository;
import com.course.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameHistoryRepository gameHistoryRepository;
	
	/**
	 * 取得 4位數字的答案
	 * @return
	 */
	public Long getAnswer() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = (UserDetails)auth.getPrincipal();
		System.out.println("USER: " + user.getUsername());
		
		List<Integer> answerList = new ArrayList<>();
		
		while (answerList.size() < 4) {
			// 隨機取得0~9的數字
			Integer num = ThreadLocalRandom.current().nextInt(0,  10);
			if (!answerList.contains(num)) {
				answerList.add(num);
			}
		}

		// 使用 List 串接成字串
		String answerStr = answerList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
		
		System.out.println("answer: " + answerStr);
		// 將答案寫入DB
		GameEntity gameEntity = new GameEntity();
		gameEntity.setAnswer(answerStr);
		gameEntity = gameRepository.save(gameEntity);

		return gameEntity.getId();
	}
	/**
	 * 檢查答案
	 * @param answer
	 * @param guessNum
	 * @return
	 */
	public ResultBean checkAnswer(String answer, String guessNum) {
		ResultBean result = new ResultBean();
		
		List<String> answerList = parseToList(answer);
		List<String> guessList = parseToList(guessNum);
		
		Integer aCount = 0;
		Integer bCount = 0;
		
		for (Integer index = 0; index < guessList.size() ; index += 1) {
			String num = guessList.get(index);
			// 數字是否有在答案之中
			Integer hitIndex = answerList.indexOf(num);
			if (hitIndex == index) {
				// 1A
				aCount += 1;
			} else if (hitIndex >= 0) {
				// 1B
				bCount += 1;
			}
		}
		
		result.setGuessNum(guessNum);
		result.setaCount(aCount);
		result.setbCount(bCount);
		result.setResultDisplay(aCount + "A" + bCount + "B");
		return result;
	}
	
	/**
	 * 將數字字串的每個數字轉換成字串陣列
	 * "1234" -> {"1", "2", "3", "4"}
	 * @param num
	 * @return
	 */
	private List<String> parseToList(String num) {
		List<String> list = new ArrayList<>();
		for(char c : num.toCharArray()) {
			list.add(String.valueOf(c));
		}
		return list;
	}

	/**
	 * 檢查答案
	 * @param answer
	 * @param guessNum
	 * @return
	 */
	public ResultBean checkAnswer(Long gameId, String guessNum) {
		ResultBean result = new ResultBean();
		// 透過 ID 取得 答案
		GameEntity game = gameRepository.findById(gameId).orElse(null);
		
		List<String> answerList = parseToList(game.getAnswer());
		List<String> guessList = parseToList(guessNum);
		
		Integer aCount = 0;
		Integer bCount = 0;
		
		for (Integer index = 0; index < guessList.size() ; index += 1) {
			String num = guessList.get(index);
			// 數字是否有在答案之中
			Integer hitIndex = answerList.indexOf(num);
			if (hitIndex == index) {
				// 1A
				aCount += 1;
			} else if (hitIndex >= 0) {
				// 1B
				bCount += 1;
			}
		}
		
		result.setGuessNum(guessNum);
		result.setaCount(aCount);
		result.setbCount(bCount);
		result.setResultDisplay(aCount + "A" + bCount + "B");
		
		GameHistoryEntity historyEntity = new GameHistoryEntity();
		historyEntity.setGameId(gameId);
		historyEntity.setGuessNum(guessNum);
		historyEntity.setGuessResult(result.getResultDisplay());

		gameHistoryRepository.save(historyEntity);
		return result;
	}
	
	public List<ResultBean> getHistory(Long gameId) {
		List<GameHistoryEntity> historyList = gameHistoryRepository.findByGameId(gameId);
		
		return historyList.stream().map(history -> {
			ResultBean bean = new ResultBean();
			bean.setGuessNum(history.getGuessNum());
			bean.setResultDisplay(history.getGuessResult());
			return bean;
		}).collect(Collectors.toList());
	}
}
