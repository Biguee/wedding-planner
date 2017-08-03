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
import pl.com.sages.planner.dto.CalculatorDto;
import pl.com.sages.planner.dto.CalculatorPageDto;
import pl.com.sages.planner.dto.GuestDto;
import pl.com.sages.planner.dto.GuestPageDto;
import pl.com.sages.planner.entity.Calculator;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.service.CalculatorService;
import pl.com.sages.planner.service.GuestService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * @author Justyna Salacinska
 */

@Api(description = "Calculator resource")
@RequestMapping(value = UriBuilder.PREFIX + "/calculator")
@RestController
public class CalculatorController {

    private CalculatorService calculatorService;
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @Autowired
    public CalculatorController(CalculatorService calculatorService, Mapper mapper) {
        this.calculatorService = calculatorService;
        this.mapper = mapper;
    }



    @ApiOperation(value = "Create new cost")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createCalculator(@ApiParam(name = "calculator")@RequestBody CalculatorDto calculatorDto){
        Calculator calculator = mapper.map(calculatorDto, Calculator.class);
        calculatorService.createCalculator(calculator);
        URI uri = uriBuilder.requestUriWithId(calculator.getId());
        return created(uri).build();
    }

    @ApiOperation(value = "Get current cost", response = CalculatorDto.class)
    @RequestMapping(value = "active", method = RequestMethod.GET)
    public CalculatorDto getCalculator(@ApiParam(name = "calculator")@RequestBody CalculatorDto calculatorDto) {
        return mapper.map(calculatorDto, CalculatorDto.class);
    }

    @ApiOperation(value = "Get calculator", response = CalculatorPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public CalculatorPageDto getCalculator(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "20", name = "pageSize") int pageSize) {
        ResultPage<Calculator> resultPage = calculatorService.getCalculator(pageNumber, pageSize);
        List<CalculatorDto> calculatorDtos = mapper.map(resultPage.getContent(), CalculatorDto.class);
        return new CalculatorPageDto(calculatorDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
    @ApiOperation(value = "Update current cost", response = CalculatorDto.class)
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity updateCalculator(@ApiParam(name = "calculator")@RequestBody CalculatorDto calculatorDto){
        Calculator calculator = mapper.map(calculatorDto, Calculator.class);
        calculatorService.updateCalculator(calculator);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete current cost", response = CalculatorDto.class)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCalculator(@ApiParam(name = "calculator") @PathVariable("id") long id){
        calculatorService.deleteCalculator(id);
        return ResponseEntity.noContent().build();
    }


}
