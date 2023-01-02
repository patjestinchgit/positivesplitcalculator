package be.positive.calculator.positivesplitcalculator.controller;

import be.positive.calculator.positivesplitcalculator.exception.TypeCurveAllReadyExists;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveDoesNotExistsException;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveUsedByRunException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SplitsCalculatorExceptionController {

	@ExceptionHandler(value = TypeCurveAllReadyExists.class)
	public ResponseEntity<Object> exception (TypeCurveAllReadyExists exception) {
		return new ResponseEntity<>("Type of curve alreday exists.", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = TypeCurveDoesNotExistsException.class)
	public ResponseEntity<Object> exception (TypeCurveDoesNotExistsException exception) {
		return new ResponseEntity<>("Type of curve does not exists.", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = TypeCurveUsedByRunException.class)
	public ResponseEntity<Object> exception (TypeCurveUsedByRunException exception) {
		return new ResponseEntity<>("This type of curve is used by the following runs: .", HttpStatus.CONFLICT);
	}


}
