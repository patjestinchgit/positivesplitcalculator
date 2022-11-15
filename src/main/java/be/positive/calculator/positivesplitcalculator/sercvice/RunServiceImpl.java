package be.positive.calculator.positivesplitcalculator.sercvice;

import be.positive.calculator.positivesplitcalculator.entity.Run;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import be.positive.calculator.positivesplitcalculator.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunServiceImpl implements RunService{
    //private final RunRepository runRepository;

    public RunServiceImpl() {
        //this.runRepository = runRepository;
    }

    public RunRecord getRunRecord(Long id) {
        return null; //runRepository.getOne(id);
    }

    @Override
    public RunRecord createNewRunRecord(Run run) {
        /* TODO: check if is existing
        *        if not create a new one and save if  database is existing possible*/
        return null;
    }
}
