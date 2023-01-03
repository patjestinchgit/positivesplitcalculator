package be.positive.calculator.positivesplitcalculator.sercvice.impl;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.adapt.RunEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.RunEntityNew;
import be.positive.calculator.positivesplitcalculator.mapper.RunEntityRecordMapper;
import be.positive.calculator.positivesplitcalculator.mapper.RunRecordDTOMapper;
import be.positive.calculator.positivesplitcalculator.mapper.TypeCurveEntityRecordMapper;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import be.positive.calculator.positivesplitcalculator.repository.RunRepository;
import be.positive.calculator.positivesplitcalculator.sercvice.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RunServiceImpl implements RunService {
    private final RunRepository runRepository;
    private final RunEntityRecordMapper runEntityRecordMapper;
    private final TypeCurveEntityRecordMapper typeCurveEntityRecordMapper;
    private final RunRecordDTOMapper runRecordDTOMapper;

    @Autowired
    public RunServiceImpl(RunRepository runRepository, RunEntityRecordMapper runEntityRecordMapper, TypeCurveEntityRecordMapper typeCurveEntityRecordMapper, RunRecordDTOMapper runRecordDTOMapper) {
        this.runRepository = runRepository;
        this.runEntityRecordMapper = runEntityRecordMapper;
        this.typeCurveEntityRecordMapper = typeCurveEntityRecordMapper;
        this.runRecordDTOMapper = runRecordDTOMapper;
    }

    public RunRecordDto getRunRecord(Long id) {
        RunRecord runRecord = new RunRecord();
        RunRecordDto runRecordDto = new RunRecordDto();
        TypeCurveEntityCreated typeCurveEntityCreated = new TypeCurveEntityCreated();
        if(Optional.of(runRepository.findById(id)).orElseThrow().isPresent()) {
            runRecord = runRepository.findById(id).get();
        }
        runRecordDTOMapper.mapRecordDto(runRecord, runRecordDto);
        typeCurveEntityRecordMapper.mapRecordEntityBasicFields(runRecord.getTypeCurveRecord(), typeCurveEntityCreated);
        runRecordDto.setTypeCurveEntityCreated(typeCurveEntityCreated);
        return runRecordDto;
    }

    @Override
    public RunEntityCreated createNewRunRecord(RunEntityNew runEntityNew) {
        /* TODO: check if is existing
        *        if not create a new one and save if  database is existing possible*/
       if(!checkExisting(runEntityNew)) {

        }
        else {

        }
        return null;
    }

    private boolean checkExisting(RunEntityNew runEntity) {
        for(RunRecord runRecord : runRepository.findAll()) {
            runEntityRecordMapper.mapNewEntityRecord(runEntity, runRecord);
        }
        return false;
    }

}
