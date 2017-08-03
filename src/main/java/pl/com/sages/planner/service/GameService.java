package pl.com.sages.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.sages.common.model.ResultPage;
import pl.com.sages.planner.entity.Game;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.repository.GameRepository;
import pl.com.sages.planner.repository.GuestRepository;

/**
 * Created by 8760w on 2017-07-27.
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //create
    public void createGame(Game game){
        gameRepository.save(game);
    }
    //read
    public Game readGame(long id){
        return gameRepository.findOne(id);
    }
    //update
    public void updateGame(Game game){
        gameRepository.save(game);
    }

    //delete
    public void deleteGame(Long id) {
        gameRepository.delete(id);
    }
    //list
    public Iterable<Game> allGames(){
        return gameRepository.findAll();
    }

    public ResultPage<Game> getGame(int pageNumber, int pageSize) {
        Page<Game> gamePage = gameRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(gamePage.getContent(), gamePage.getNumber(), gamePage.getTotalPages());
    }

}
