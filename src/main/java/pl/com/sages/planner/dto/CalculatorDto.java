package pl.com.sages.planner.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.sages.planner.entity.CateringKind;

/**
 * Created by 8760w on 2017-07-27.
 */
@Data
@ApiModel(value = "Calculator")
public class CalculatorDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private Double cost;
}
