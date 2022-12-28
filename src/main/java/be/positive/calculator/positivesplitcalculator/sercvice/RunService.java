package be.positive.calculator.positivesplitcalculator.sercvice;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.RunEntity;

public interface RunService {

    public RunRecordDto getRunRecord(Long id);
    RunEntity createNewRunRecord(RunEntity runEntity);
}
