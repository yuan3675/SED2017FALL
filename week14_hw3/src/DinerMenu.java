import java.util.ArrayList;

public class DinerMenu implements Menu {
    private ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    private boolean isSub;

    public DinerMenu(boolean isSub) {
        this.isSub = isSub;
    }

    public ArrayList<MenuComponent> getMenuComponents() {
        return menuComponents;
    }

    @Override
    public void print() {
        if (isSub) {
            System.out.println("SubMenu:");
        }
        else {
            System.out.println("DinerMenu:");
        }
        DinerMenuIterator dinerMenuIterator = createIterator();
        while (!dinerMenuIterator.isDone()) {
            MenuComponent menuComponent = dinerMenuIterator.next();
            menuComponent.print();
        }
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public DinerMenuIterator createIterator() {
        return new DinerMenuIterator(this);
    }

    @Override
    public MenuComponent get(int index) {
        return menuComponents.get(index);
    }

    @Override
    public int size() {
        return menuComponents.size();
    }
}
