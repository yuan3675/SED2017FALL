import java.util.ArrayList;

public class SListT {
    public void traverse(SkipList skipList) {
        for(int i=0; i < skipList.getSize(); i++) {
            System.out.println(skipList.getNode(i));
        }
    }
}
