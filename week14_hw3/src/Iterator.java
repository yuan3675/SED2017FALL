public interface Iterator {
    public MenuComponent first();
    public MenuComponent next();
    public boolean isDone();
    public MenuComponent currentItem();
}
