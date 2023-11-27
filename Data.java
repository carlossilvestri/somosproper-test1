public class Data {
    Integer id;
    String name;

    Integer idFather;

    public Data(Integer id, String name, Integer idFather) {
        this.id = id;
        this.name = name;
        this.idFather = idFather;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdFather() {
        return idFather;
    }

    public void setIdFather(Integer idFather) {
        this.idFather = idFather;
    }
}
