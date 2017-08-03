package pl.com.sages.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.sages.common.model.ResultPage;
import pl.com.sages.planner.entity.Calculator;
import pl.com.sages.planner.entity.Catering;
import pl.com.sages.planner.repository.CalculatorRepository;
import pl.com.sages.planner.repository.CateringRepository;

/**
 * Created by 8760w on 2017-07-27.
 */
@Service
public class CalculatorService {

    @Autowired
    private CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    //create
    public void createCalculator(Calculator calculator){
        calculatorRepository.save(calculator);
    }
    //read
    public Calculator readCalculator(long id){
        return calculatorRepository.findOne(id);
    }
    //update
    public void updateCalculator(Calculator calculator){
        calculatorRepository.save(calculator);
    }

    //delete
    public void deleteCalculator(Long id) {
        calculatorRepository.delete(id);
    }
    //list
    public Iterable<Calculator> allCalculators(){
        return calculatorRepository.findAll();
    }

    public ResultPage<Calculator> getCalculator(int pageNumber, int pageSize) {
        Page<Calculator> calculatorPage = calculatorRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(calculatorPage.getContent(), calculatorPage.getNumber(), calculatorPage.getTotalPages());
    }

}
