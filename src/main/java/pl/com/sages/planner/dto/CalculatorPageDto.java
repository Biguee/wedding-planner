package pl.com.sages.planner.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created by 8760w on 2017-07-27.
 */
@Data
@ApiModel(value = "Calculator")
public class CalculatorPageDto {

    private List<CalculatorDto> calculator;
    private int pageNumber;
    private int totalPages;

    public CalculatorPageDto() {
    }

    public CalculatorPageDto(List<CalculatorDto> calculator, int pageNumber, int totalPages) {
        this.calculator = calculator;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}
