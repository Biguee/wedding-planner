package pl.com.sages.planner.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.sages.planner.entity.CateringKind;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by 8760w on 2017-07-27.
 */
@Data
@ApiModel(value = "Catering")
public class CateringDto {

    @ApiModelProperty(required = true)
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty
    private CateringKind kind;
}
