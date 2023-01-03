package be.positive.calculator.positivesplitcalculator.sercvice;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.adapt.RunEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.RunEntityNew;

public interface RunService {

    public RunRecordDto getRunRecord(Long id);
    RunEntityCreated createNewRunRecord(RunEntityNew runEntity);
}
