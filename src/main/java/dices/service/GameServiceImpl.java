package dices.service;

import dices.exceptions.PlayerNotFoundException;
import dices.model.Player;
import dices.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dices.model.Game;
import dices.repository.IGameRepository;

import java.util.List;

@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    IGameRepository iGameRepository;

    @Autowired
    IPlayerRepository iPlayerRepository;

    @Override
    public List<Game> listGames() {
        return iGameRepository.findAll();
    }

    @Override
    public List<Game> getGamesByPlayer(Long player_id) {
        Player myPlayer2 = iPlayerRepository.findById(player_id).get();
        if(myPlayer2 == null) {
            throw new PlayerNotFoundException(player_id);
        }
        return iGameRepository.findByPlayer(myPlayer2);
    }

    @Override
    public void deleteGamesByPlayer(Long player_id) {
        Player myPlayer = iPlayerRepository.findById(player_id).get();
        if(myPlayer == null) {
            throw new PlayerNotFoundException(player_id);
        }
        myPlayer.setWins(0);
        myPlayer.setRate(0);
        iGameRepository.deleteByPlayer(myPlayer);
    }
}