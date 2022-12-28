package be.positive.calculator.positivesplitcalculator.mapper;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class RunRecordDTOMapper {

    private final DtoRecordMapper dtoRecordMapper;

    public RunRecordDTOMapper () {
        this.dtoRecordMapper = new DtoRecordMapper();
    }

    public void mapDtoRecord(RunRecordDto runRecordDto, RunRecord runRecord) {
        dtoRecordMapper.map(runRecordDto, runRecord);
    }

    public RunRecordDto mapRecordDto(RunRecord runRecord, RunRecordDto runRecordDto) {
        dtoRecordMapper.map(runRecord, runRecordDto);
        return runRecordDto;
    }

    static class DtoRecordMapper extends ConfigurableMapper {
        @Override
        protected void configure(MapperFactory factory) {
            factory.classMap(RunRecordDto.class, RunRecord.class)
                    .byDefault().register();
        }
    }
}
