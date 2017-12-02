import java.util.ArrayList;

public interface Chart {
    public abstract String getType();
    public abstract void update(String name, int value);
    public abstract void change(String name, int value);
    public abstract void display();
}
