
public class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void put(T t) {
        this.t = t;
    }
}
