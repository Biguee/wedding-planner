package pl.com.sages.planner.dto;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import pl.com.sages.planner.entity.Game;

import java.util.List;

/**
 * Created by 8760w on 2017-07-25.
 */
@Data
@ApiModel(value = "Game")
public class GamePageDto {

    private List<GameDto> games;
    private int pageNumber;
    private int totalPages;

    public GamePageDto() {
    }

    public GamePageDto(List<GameDto> games, int pageNumber, int totalPages) {
        this.games = games;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }
}
