package cn.hykes.boot.domain;

import java.io.Serializable;

/**
 * Desc:
 * author:HeHaiYang
 * Date:16/1/18
 */

public class City implements Serializable {

    private static final long serialVersionUID = -6515602767646379940L;

    private Long id;

    private String name;

    private String state;

    private String country;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", state='" + this.state + '\'' +
                ", country='" + this.country + '\'' +
                '}';
    }
}
