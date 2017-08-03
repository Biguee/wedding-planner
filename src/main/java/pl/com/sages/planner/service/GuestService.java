package pl.com.sages.planner.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.sages.common.model.ResultPage;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.repository.GuestRepository;
import pl.com.sages.security.entity.User;

import java.util.List;

/**
 * Created by 8760w on 2017-07-26.
 */
@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    //create
    public void createGuest(Guest guest){
        guestRepository.save(guest);
    }
    //read
    public Guest readGuest(long id){
        return guestRepository.findOne(id);
    }
    //update
    public void updateGuest(Guest guest){
        guestRepository.save(guest);
    }

    //delete
    public void deleteGuest(Long id) {
        guestRepository.delete(id);
    }
    //list
    public Iterable<Guest> allGuests(){
        return guestRepository.findAll();
    }

    public ResultPage<Guest> getGuest(int pageNumber, int pageSize) {
        Page<Guest> guestPage = guestRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(guestPage.getContent(), guestPage.getNumber(), guestPage.getTotalPages());
    }
}
