public class TR {
    private String name, type;
    private int ind;
    public TR(int i, String n, String t) {
        this.ind = i;
        this.name = n;
        this.type = t;
    }
    public int getIndex() {
        return ind;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
}