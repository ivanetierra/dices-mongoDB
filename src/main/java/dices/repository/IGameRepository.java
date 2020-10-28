package dices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import dices.model.Game;
import dices.model.Player;

import java.util.List;

public interface IGameRepository extends MongoRepository<Game, Long> {

    List<Game> findByPlayer(Player player);

    @Transactional
    void deleteByPlayer(Player player);

}



