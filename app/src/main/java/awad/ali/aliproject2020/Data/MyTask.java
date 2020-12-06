package awad.ali.aliproject2020.Data;

public class MyTask
{
    public int getImportant;
    private String key;
    private String title;
    private String sub;
    private String owner;
    private int nec;
    private int skr;

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void getKey(){

    }

    @Override
    public String toString() {
        return "MyTask{" +
                "owner='" + owner + '\'' +
                ", nec=" + nec +
                ", skr=" + skr +
                '}';
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getNec() {
        return nec;
    }

    public void setNec(int nec) {
        this.nec = nec;
    }

    public int getSkr() {
        return skr;
    }

    public void setSkr(int skr) {
        this.skr = skr;
    }
}
