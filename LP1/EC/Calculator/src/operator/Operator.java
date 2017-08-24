package operator;

import java.util.ArrayList;
import java.util.Arrays;

public final class Operator implements Operable<Number> {
	private double value = 0;
	Number result = new Number() {
		@Override
		public long longValue() {
			return (long) value;
		}

		@Override
		public int intValue() {
			return (int) value;
		}

		@Override
		public float floatValue() {
			return (float) value;
		}

		@Override
		public double doubleValue() {
			return value;
		}
	};

	@Override
	public Number Sum(Number value) {
		this.value += value.doubleValue();
		return result;
	}

	@Override
	public Number Subtract(Number value) {
		this.value -= value.doubleValue();
		return result;
	}

	@Override
	public Number Divide(Number... values) {
		value = 0;
		for (Number number : values) {
			value /= number.doubleValue();
		}
		return result;
	}

	@Override
	public Number Multiply(Number... values) {
		value = 0;
		for (Number number : values) {
			value *= number.doubleValue();
		}
		return result;
	}

	public Number Operate(String operation) {
		ArrayList<String> values = new ArrayList<String>();
		String[] blocks = operation.split("[\\-\\+]([0-9]+)");
		for (String string : blocks) {
			if(string.isEmpty())
				continue;
			values.add(string);
		}
		try {
		for (int i = 0; i < values.size(); i++) {
			String strValue = values.get(i);
			if(isNumber(strValue)) {
				double dValue = Double.parseDouble(strValue);
				switch (strValue) {
				case "+":
					Sum(dValue);
					break;
				case "-":
					Subtract(dValue);
					break;
				default:
					break;
				}
				values.remove(i);
			}
			else {
				System.out.printf("Not a number: [%s]\n", values.get(i));
			}
		}	
		}
		catch(Exception exc) {
			return null;
		}
		//
		return result;
	}

	private boolean isNumber(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
