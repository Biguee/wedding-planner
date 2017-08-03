package pl.com.sages.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.sages.common.model.ResultPage;
import pl.com.sages.planner.entity.Catering;
import pl.com.sages.planner.entity.Guest;
import pl.com.sages.planner.repository.CateringRepository;
import pl.com.sages.planner.repository.GuestRepository;

/**
 * Created by 8760w on 2017-07-27.
 */
@Service
public class CateringService {

    @Autowired
    private CateringRepository cateringRepository;

    public CateringService(CateringRepository cateringRepository) {
        this.cateringRepository = cateringRepository;
    }

    //create
    public void createCatering(Catering catering){
        cateringRepository.save(catering);
    }
    //read
    public Catering readCatering(long id){
        return cateringRepository.findOne(id);
    }
    //update
    public void updateCatering(Catering catering){
        cateringRepository.save(catering);
    }

    //delete
    public void deleteCatering(Long id) {
        cateringRepository.delete(id);
    }
    //list
    public Iterable<Catering> allCatering(){
        return cateringRepository.findAll();
    }

    public ResultPage<Catering> getCatering(int pageNumber, int pageSize) {
        Page<Catering> cateringPage = cateringRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(cateringPage.getContent(), cateringPage.getNumber(), cateringPage.getTotalPages());
    }

}
