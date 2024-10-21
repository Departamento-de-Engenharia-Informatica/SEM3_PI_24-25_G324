package prodPlanSimulator.utils;

public interface DataParser<T> {
    /**
     * Parse the data and return an object
     * @param data the data to be parsed
     * @return the object parsed
     */
    T parse(String[] data);
}
