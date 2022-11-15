package be.positive.calculator.positivesplitcalculator.controller;

import be.positive.calculator.positivesplitcalculator.entity.Run;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import be.positive.calculator.positivesplitcalculator.sercvice.RunServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/runs")
public class SplitCalculatorController {
    private final RunServiceImpl runServiceImpl;

    public SplitCalculatorController(RunServiceImpl runServiceImpl) {
        this.runServiceImpl = runServiceImpl;
    }

    @GetMapping("/greeting")
    public String getRoot() {
        return "Hello from root";
    }

    @GetMapping("/run/{id}")
    public String getRunRecord(@PathVariable Long id) {
        System.out.println("id: "+id);
        return id.toString();
    }

    @PostMapping("/{run}")
    public RunRecord calculateNewRun(@RequestBody Run run) {
        return runServiceImpl.createNewRunRecord(run);
    }

}
