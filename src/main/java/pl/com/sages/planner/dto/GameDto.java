package pl.com.sages.planner.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Justyna Salacinska
 */

@Data
@ApiModel(value = "Game")
public class GameDto {

    @ApiModelProperty(required = true)
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty
    private String description;

}
