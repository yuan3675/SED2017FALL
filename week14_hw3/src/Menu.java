public interface Menu extends MenuComponent{
    public MenuComponent get(int index);
    public Iterator createIterator();
    public void add(MenuComponent menuComponent);
    public int size();
}
