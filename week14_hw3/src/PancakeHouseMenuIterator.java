import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
    private PancakeHouseMenu pancakeHouseMenu;
    private ArrayList<MenuComponent> menuItems;
    private int index = 0;

    public PancakeHouseMenuIterator(PancakeHouseMenu pancakeHouseMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.menuItems = this.pancakeHouseMenu.getMenuItems();
    }
    @Override
    public MenuComponent next() {
        this.index ++;
        if (this.index <= menuItems.size()) {
            return menuItems.get(index - 1);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isDone() {
        if (index == menuItems.size()) {
            return true;
        }
        return false;
    }

    @Override
    public MenuComponent currentItem() {
        return menuItems.get(index);
    }

    @Override
    public MenuComponent first() {
        return menuItems.get(0);
    }
}
