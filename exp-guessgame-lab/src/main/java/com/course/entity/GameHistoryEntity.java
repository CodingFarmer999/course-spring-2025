package com.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game_history")
public class GameHistoryEntity {

	/** 鍵值 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 遊戲ID */
	@Column(name = "game_id")
	private Long gameId;
	
	/** 猜的數字 */
	@Column(name = "guess_num")
	private String guessNum;
	
	/** 猜的結果*/
	@Column(name = "guess_result")
	private String guessResult;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getGuessNum() {
		return guessNum;
	}

	public void setGuessNum(String guessNum) {
		this.guessNum = guessNum;
	}

	public String getGuessResult() {
		return guessResult;
	}

	public void setGuessResult(String guessResult) {
		this.guessResult = guessResult;
	}
}
