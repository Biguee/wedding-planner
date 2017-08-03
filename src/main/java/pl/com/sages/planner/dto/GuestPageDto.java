package pl.com.sages.planner.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.security.dto.UserDto;

import java.util.List;

/**
 * Created by 8760w on 2017-07-25.
 */
@Data
@ApiModel(value = "Guest")
public class GuestPageDto {

    private List<GuestDto> guests;
    private int pageNumber;
    private int totalPages;

    public GuestPageDto() {
    }

    public GuestPageDto(List<GuestDto> guests, int pageNumber, int totalPages) {
        this.guests = guests;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }
}
