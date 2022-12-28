package be.positive.calculator.positivesplitcalculator.converter;

import be.positive.calculator.positivesplitcalculator.entity.RunEntity;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

@Converter
public class RunConverter implements AttributeConverter<RunEntity, RunRecord> {

    @Override
    public RunRecord convertToDatabaseColumn(RunEntity runEntity) {
        return null;
    }

    @Override
    public RunEntity convertToEntityAttribute(RunRecord runRecord) {
        return null;
    }
}
