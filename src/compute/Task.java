package compute;

public interface Task<T> {
    T execute();
    T retrieve();
}