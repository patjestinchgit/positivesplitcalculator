package be.positive.calculator.positivesplitcalculator.mapper;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RunRecordDTOMapper {

    private final DtoRecordMapper dtoRecordMapper;

    public RunRecordDTOMapper() {
        this.dtoRecordMapper = new DtoRecordMapper();
    }

    public List<RunRecordDto> mappingRunDtoList(List<RunRecord> runRecords) {
        List<RunRecordDto> runRecordDtoList = new ArrayList<>();
        RunRecordDto runRecordDto = new RunRecordDto();
        for (RunRecord runRecord : runRecords) {
            mapRecordDto(runRecord, runRecordDto);
            runRecordDtoList.add(runRecordDto);
        }
        return runRecordDtoList;
    }

    public void mapDtoRecord(RunRecordDto runRecordDto, RunRecord runRecord) {
        dtoRecordMapper.map(runRecordDto, runRecord);
    }

    public RunRecordDto mapRecordDto(RunRecord runRecord, RunRecordDto runRecordDto) {
        dtoRecordMapper.map(runRecord, runRecordDto);
        return runRecordDto;
    }

    public static class DtoRecordMapper extends ConfigurableMapper {
        @Override
        public void configure(MapperFactory factory) {
            factory.classMap(RunRecordDto.class, RunRecord.class)
                    .byDefault().register();
        }
    }
}

