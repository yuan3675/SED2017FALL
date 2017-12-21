import java.util.ArrayList;

public class SkipList {
    private ArrayList<SkipNode> skipNodes = new ArrayList<>();

    public ArrayList<SkipNode> getSkipNodes() {
        return skipNodes;
    }

    public int getSize() {
        return skipNodes.size();
    }
    public String getNode(int index) {
        return "SkipNode:" + skipNodes.get(index).getContext();
    }
}
