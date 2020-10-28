package dices.service;

import dices.model.Game;
import dices.model.Player;

import java.util.List;

public interface IPlayerService {

	//Metodos del CRUD shop
	List<Player> listPlayers(); //list all

	Player addPlayer(Player player); //add new player

	Game playGame(Long player_id, int gamesPlayed); //play game

	Player changePlayer(Player newPlayer, Long player_id); //change player name

	List<Player> getRanking();
	Player getLoser();
	Player getWinner();

}
