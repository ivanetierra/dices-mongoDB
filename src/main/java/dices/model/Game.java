
package dices.model;


import javax.persistence.*;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection="game")
public class Game {

    @Id
    @NonNull
    //@Column(name = "id")
    private String id;

    //@Column(name = "dice1")
    private int dice1;

    //@Column(name = "dice2")
    private int dice2;

    //@Column(name = "win")
    private boolean win;

    //@ManyToOne
    //@JoinColumn(name="player_id")
    @DBRef(db = "player") //como FK
    private Player player;

    //CONSTRUCTORS

    Game() {}

    public Game(Player player) {
        this.player = player;

        int dice1 = throwDice();
        int dice2 = throwDice();
        int result = dice1 + dice2;

        boolean win = false;
        if (result == 7) {
            win = true;
        }

        this.dice1 = dice1;
        this.dice2 = dice2;
        this.win = win;

    }

    public static int throwDice() {
        int num = (int) ((Math.random()*6)+1); //returns int 1-6
        return num;
    }

    public Game(String id, int dice1, int dice2, boolean win, Player player) {
        this.id = id;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.win = win;
        this.player = player;
    }

    //GETTERS Y SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDice1() {
        return dice1;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
