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
import pl.com.sages.planner.dto.CateringDto;
import pl.com.sages.planner.dto.CateringPageDto;
import pl.com.sages.planner.dto.GuestDto;
import pl.com.sages.planner.dto.GuestPageDto;
import pl.com.sages.planner.entity.Catering;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.service.CateringService;
import pl.com.sages.planner.service.GuestService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * @author Justyna Salacinska
 */

@Api(description = "Catering resource")
@RequestMapping(value = UriBuilder.PREFIX + "/catering")
@RestController
public class CateringController {

    private CateringService cateringService;
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @Autowired
    public CateringController(CateringService cateringService, Mapper mapper) {
        this.cateringService = cateringService;
        this.mapper = mapper;
    }



    @ApiOperation(value = "Create new catering")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createCatering(@ApiParam(name = "catering")@RequestBody CateringDto cateringDto){
        Catering catering = mapper.map(cateringDto, Catering.class);
        cateringService.createCatering(catering);
        URI uri = uriBuilder.requestUriWithId(catering.getId());
        return created(uri).build();
    }

    @ApiOperation(value = "Get current catering", response = CateringDto.class)
    @RequestMapping(value = "active", method = RequestMethod.GET)
    public CateringDto getCatering(@ApiParam(name = "catering")@RequestBody CateringDto cateringDto) {
        return mapper.map(cateringDto, CateringDto.class);
    }

    @ApiOperation(value = "Get catering", response = CateringPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public CateringPageDto getCatering(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "20", name = "pageSize") int pageSize) {
        ResultPage<Catering> resultPage = cateringService.getCatering(pageNumber, pageSize);
        List<CateringDto> cateringDto = mapper.map(resultPage.getContent(), CateringDto.class);
        return new CateringPageDto(cateringDto, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
    @ApiOperation(value = "Update current catering", response = CateringDto.class)
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity updateCatering(@ApiParam(name = "catering")@RequestBody CateringDto cateringDto){
        Catering catering = mapper.map(cateringDto, Catering.class);
        cateringService.updateCatering(catering);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete current catering", response = CateringDto.class)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCatering(@ApiParam(name = "catering") @PathVariable ("id") long id){
        cateringService.deleteCatering(id);
        return ResponseEntity.noContent().build();
    }



}
