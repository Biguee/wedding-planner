package pl.com.sages.planner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.sages.security.dto.AuthorityDto;

import java.util.Set;

/**
 * @author Justyna Salacinska
 */

@Data
@ApiModel(value = "Guest")
public class GuestDto {

    @ApiModelProperty(required = true)
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String surname;


}


