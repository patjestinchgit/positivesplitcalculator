package be.positive.calculator.positivesplitcalculator.controller;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.RunEntity;
import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import be.positive.calculator.positivesplitcalculator.sercvice.impl.RunServiceImpl;
import be.positive.calculator.positivesplitcalculator.sercvice.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/runs")
public class SplitCalculatorController {
    private final RunServiceImpl runServiceImpl;
    private final TypeServiceImpl typeServiceImpl;

    @Autowired
    public SplitCalculatorController(RunServiceImpl runServiceImpl, TypeServiceImpl typeServiceImpl) {
        this.runServiceImpl = runServiceImpl;
        this.typeServiceImpl = typeServiceImpl;
    }

    @GetMapping("/greeting")
    public String getRoot() {
        return "Hello from root";
    }

    @GetMapping("/run/{id}")
    public RunRecordDto getRunRecord(@PathVariable Long id) {
        return runServiceImpl.getRunRecord(id);
    }

    @PostMapping("/{run}")
    public RunEntity calculateNewRun(@RequestBody RunEntity runEntity) {
        return runServiceImpl.createNewRunRecord(runEntity);
    }

    @GetMapping("/typecurves/all")
    public List<TypeCurveEntity> getAllTypeCurves () {
        return typeServiceImpl.getAllTypeCurves();
    }

}
