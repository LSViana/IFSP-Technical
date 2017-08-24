package operator;

public interface Operable<T extends Number> {
	T Sum(T values);
	T Subtract(T values);
	T Divide(T... values);
	T Multiply(T... values);
}
