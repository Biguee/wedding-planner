package pl.com.sages.planner.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created by 8760w on 2017-07-27.
 */
@Data
@ApiModel(value = "Catering")
public class CateringPageDto {

    private List<CateringDto> catering;
    private int pageNumber;
    private int totalPages;

    public CateringPageDto() {
    }

    public CateringPageDto(List<CateringDto> catering, int pageNumber, int totalPages) {
        this.catering = catering;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }
}
