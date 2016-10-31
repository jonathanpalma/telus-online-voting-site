package models.entities;

/**
 * Created by palma on 10/31/16.
 */
public class CountryMinified {
    private Integer id;
    private String code;
    private String name;

    public CountryMinified() {
    }

    public CountryMinified(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public CountryMinified(Country country){
        this.id = country.getId();
        this.code = country.getCode();
        this.name = country.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
