package pl.com.sages.planner.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.sages.common.model.Mapper;
import pl.com.sages.common.model.ResultPage;
import pl.com.sages.common.web.UriBuilder;
import pl.com.sages.planner.dto.GameDto;
import pl.com.sages.planner.dto.GamePageDto;
import pl.com.sages.planner.dto.GuestDto;
import pl.com.sages.planner.dto.GuestPageDto;
import pl.com.sages.planner.entity.Game;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.service.GameService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * @author Justyna Salacinska
 */

@Api(description = "Games resource")
@RequestMapping(value = UriBuilder.PREFIX + "/games")
@RestController
public class GameController {

    private GameService gameService;
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @Autowired
    public GameController(GameService gameService, Mapper mapper) {
        this.gameService = gameService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "Create new game")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createGame(@ApiParam(name = "game")@RequestBody GameDto gameDto){
        Game game = mapper.map(gameDto, Game.class);
        gameService.createGame(game);
        URI uri = uriBuilder.requestUriWithId(game.getId());
        return created(uri).build();
    }

    @ApiOperation(value = "Get current game", response = GameDto.class)
    @RequestMapping(value = "active", method = RequestMethod.GET)
    public GameDto getGame(@ApiParam(name = "game")@RequestBody GameDto gameDto) {
        return mapper.map(gameDto, GameDto.class);
    }

    @ApiOperation(value = "Get games", response = GamePageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public GamePageDto getGames(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "20", name = "pageSize") int pageSize) {
        ResultPage<Game> resultPage = gameService.getGame(pageNumber, pageSize);
        List<GameDto> gameDtos = mapper.map(resultPage.getContent(), GameDto.class);
        return new GamePageDto(gameDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }

    @ApiOperation(value = "Update current game", response = GameDto.class)
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity updateGame(@ApiParam(name = "game")@RequestBody GameDto gameDto){
        Game game = mapper.map(gameDto, Game.class);
        gameService.updateGame(game);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete current game", response = GameDto.class)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteGame(@ApiParam(name = "game") @PathVariable ("id") long id){
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }



}
