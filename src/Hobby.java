public class Hobby {
    private int id=0;
    private String name=null;

    public Hobby(){
        setId(0);
        setName("");
    }

    public Hobby(int id, String name){
        setId(id);
        setName(name);
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
