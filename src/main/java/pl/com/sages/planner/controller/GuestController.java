package pl.com.sages.planner.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import pl.com.sages.common.model.Mapper;
import pl.com.sages.common.model.ResultPage;
import pl.com.sages.common.web.UriBuilder;
import pl.com.sages.planner.dto.GuestDto;
import pl.com.sages.planner.dto.GuestPageDto;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.service.GuestService;
import pl.com.sages.security.dto.UserDto;
import pl.com.sages.security.dto.UsersPageDto;
import pl.com.sages.security.entity.User;
import pl.com.sages.security.entity.UserProfile;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * @author Justyna Salacinska
 */

@Api(description = "Guests resource")
@RequestMapping(value = UriBuilder.PREFIX + "/guests")
@RestController
public class GuestController {

    private GuestService guestService;
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @Autowired
    public GuestController(GuestService guestService, Mapper mapper) {
        this.guestService = guestService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "Create new guest")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createGuest(@ApiParam(name = "guest")@RequestBody GuestDto guestDto){
        Guest guest = mapper.map(guestDto, Guest.class);
        guestService.createGuest(guest);
        URI uri = uriBuilder.requestUriWithId(guest.getId());
        return created(uri).build();
    }

    @ApiOperation(value = "Get current guest", response = GuestDto.class)
    @RequestMapping(value = "active", method = RequestMethod.GET)
    public GuestDto getGuest(@ApiParam(name = "guest")@RequestBody GuestDto guestDto) {
        return mapper.map(guestDto, GuestDto.class);
    }

    @ApiOperation(value = "Get guests", response = GuestPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public GuestPageDto getGuest(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "20", name = "pageSize") int pageSize) {
        ResultPage<Guest> resultPage = guestService.getGuest(pageNumber, pageSize);
        List<GuestDto> guestDtos = mapper.map(resultPage.getContent(), GuestDto.class);
        return new GuestPageDto(guestDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
    @ApiOperation(value = "Update current guest", response = GuestDto.class)
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity updateGuest(@ApiParam(name = "guest")@RequestBody GuestDto guestDto){
        Guest guest = mapper.map(guestDto, Guest.class);
        guestService.updateGuest(guest);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete current guest", response = GuestDto.class)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteGuest(@ApiParam(name = "guest") @PathVariable ("id") long id){
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }



}