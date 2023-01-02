package be.positive.calculator.positivesplitcalculator.mapper;

import org.springframework.stereotype.Component;

@Component
public class RunEntityRecordMapper {

}
/*
    private final EntityRecordMapper entityRecordMapper;

    public RunEntityRecordMapper() {
        this.entityRecordMapper = new EntityRecordMapper();
    }

    public void mapEntityRecord(RunEntity runEntity, RunRecord runRecord) {
        entityRecordMapper.map(runEntity, runRecord);
    }

    public void mapRecordEntity(RunRecord runRecord, RunEntity runEntity) {
        entityRecordMapper.map(runRecord, runEntity);
    }

    static class EntityRecordMapper extends ConfigurableMapper {
        protected void configure(MapperFactory factory) {
            factory.classMap(RunEntity.class, RunRecord.class).field("name", "nameRunRecord").byDefault().register();
        }
    }
}*/
