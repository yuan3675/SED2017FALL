import java.util.ArrayList;

public class PancakeHouseMenu implements Menu {
    private ArrayList<MenuComponent> menuItems = new ArrayList<>();

    public ArrayList<MenuComponent> getMenuItems() {
        return menuItems;
    }

    @Override
    public MenuComponent get(int index) {
        return menuItems.get(index);
    }

    @Override
    public PancakeHouseMenuIterator createIterator() {
        return new PancakeHouseMenuIterator(this);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuItems.add(menuComponent);
    }

    @Override
    public int size() {
        return menuItems.size();
    }

    @Override
    public void print() {
        System.out.println("PancakeHouseMenu:");
        PancakeHouseMenuIterator pancakeHouseMenuIterator = createIterator();
        while (!pancakeHouseMenuIterator.isDone()) {
            MenuComponent menuComponent = pancakeHouseMenuIterator.next();
            menuComponent.print();
        }
    }
}
