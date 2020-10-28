package dices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dices.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IPlayerRepository extends MongoRepository<Player, Long> {

    boolean existsByName(String name);

}
