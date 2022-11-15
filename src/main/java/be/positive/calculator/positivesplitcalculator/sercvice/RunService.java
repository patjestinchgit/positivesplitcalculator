package be.positive.calculator.positivesplitcalculator.sercvice;

import be.positive.calculator.positivesplitcalculator.entity.Run;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;

public interface RunService {

    public RunRecord getRunRecord(Long id);
    public RunRecord createNewRunRecord(Run run);
}
