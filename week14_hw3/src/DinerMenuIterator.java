import java.util.ArrayList;

public class DinerMenuIterator implements Iterator {
    private DinerMenu dinerMenu;
    private ArrayList<MenuComponent> menuComponents;
    private int index = 0;

    public DinerMenuIterator(DinerMenu dinerMenu) {
        this.dinerMenu = dinerMenu;
        this.menuComponents = this.dinerMenu.getMenuComponents();
    }
    @Override
    public MenuComponent first() {
        return this.menuComponents.get(0);
    }

    @Override
    public boolean isDone() {
        if (index == menuComponents.size()) {
            return true;
        }
        return false;
    }

    @Override
    public MenuComponent next() {
        this.index ++;
        if (this.index <= menuComponents.size()) {
            return menuComponents.get(index -1);
        }
        else {
            return null;
        }
    }

    @Override
    public MenuComponent currentItem() {
        return this.menuComponents.get(index);
    }
}
