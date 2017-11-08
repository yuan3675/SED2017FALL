public class Component {
    private int ID;
    private int natureSize;
    private int shrinkability;
    private int stretchability;
    private String content;
    private String type;

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setNatureSize(int size) {
        this.natureSize = size;
    }
    public void setShrinkability(int s) {
        this.shrinkability = s;
    }
    public  void setStretchability(int s) {
        this.stretchability = s;
    }
    public void setContent(String s) {
        this.content = s;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return this.ID;
    }

    public int getNatureSize() {
        return natureSize;
    }

    public int getShrinkability() {
        return shrinkability;
    }

    public int getStretchability() {
        return stretchability;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }
}
