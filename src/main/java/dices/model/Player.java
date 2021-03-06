package dices.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Document(collection="player")
public class Player {

    @Id
    @NonNull
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@Column(name = "name")
    private String name;

    //@Temporal(TemporalType.TIMESTAMP)
    // @Column(name = "date")
    private Date date;


    //@Column(name = "wins")
    private int wins;

    //@Column(name = "rate")
    private float rate;


    // @OneToMany
    //@JoinColumn(name="id")
    private List<Game> games;

    //CONSTRUCTORS

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(Long id, String name, Date date, int wins, float rate) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.wins = wins;
        this.rate = rate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    //@JsonIgnore
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "Game")
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}




