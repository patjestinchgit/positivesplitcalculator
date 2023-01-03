package be.positive.calculator.positivesplitcalculator.mapper;

import be.positive.calculator.positivesplitcalculator.entity.adapt.RunEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.RunEntityNew;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class RunEntityRecordMapper {

    private final NewEntityRecordMapper newEntityRecordMapper;
    private final CreateEntityRecordMapper createdEntityRecordMapper;

    public RunEntityRecordMapper() {
        this.newEntityRecordMapper = new NewEntityRecordMapper();
        this.createdEntityRecordMapper = new CreateEntityRecordMapper();
    }

    public void mapNewEntityRecord(RunEntityNew runEntity, RunRecord runRecord) {
        newEntityRecordMapper.map(runEntity, runRecord);
    }

    public void mapRecordNewEntity(RunRecord runRecord, RunEntityNew runEntity) {
        newEntityRecordMapper.map(runRecord, runEntity);
    }

    public void mapCreatedEntityRecord(RunEntityCreated runEntity, RunRecord runRecord) {
        newEntityRecordMapper.map(runEntity, runRecord);
    }

    public void mapRecordCreatedEntity(RunRecord runRecord, RunEntityCreated runEntity) {
        newEntityRecordMapper.map(runRecord, runEntity);
    }


    static class NewEntityRecordMapper extends ConfigurableMapper {
        protected void configure(MapperFactory factory) {
            factory.classMap(RunEntityNew.class, RunRecord.class).field("name", "nameRunRecord").byDefault().register();
        }
    }

    static class CreateEntityRecordMapper extends ConfigurableMapper {
        protected void configure(MapperFactory factory) {
            factory.classMap(RunEntityCreated.class, RunRecord.class).field("name", "nameRunRecord").byDefault().register();
        }
    }
}
