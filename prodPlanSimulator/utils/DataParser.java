package prodPlanSimulator.utils;

public interface DataParser<T> {
    T parse(String[] data);
}
