package be.positive.calculator.positivesplitcalculator.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TypeCurveDoesNotExistsException extends RuntimeException {
	private static final long serialVersionUID= 1L;

	public TypeCurveDoesNotExistsException(String message) {
		super(message);
	}
}
