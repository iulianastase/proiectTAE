package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by inastase on 11/22/2016.
 */
@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;

    @Column(name = "name")
    private String cityName;

    @Column(name = "jsonWeather",columnDefinition = "Text")
    private String jsonWeather;

    @Column(name = "date", nullable = false)
    private Date date;


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(joinColumns = {@JoinColumn(name = "cityId")},
//            inverseJoinColumns = {@JoinColumn(name = "userId")})
    @ManyToMany( mappedBy = "cities", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users;

    public City(String cityName, List<User> users, String jsonWeather, Date date) {
        this.cityName = cityName;
        this.users = users;
        this.jsonWeather = jsonWeather;
        this.date = date;
    }

    public City(String cityName){
        this.cityName = cityName;
    }

    public String getJsonWeather() {

        return jsonWeather;
    }

    public void setJsonWeather(String jsonWeather) {
            this.jsonWeather = jsonWeather;
    }

    public City() {
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", users=" + users +
                '}';
    }

    @PreRemove
    public void preDelete() {
        Iterator<User> it = this.getUsers().iterator();
        System.out.println("In @PreRemove");
        System.out.println(this.getUsers());
        while(it.hasNext()) {
            User current = it.next();
            System.out.println("Deleting ref from user");
            System.out.println(current.getCities().remove(this));
        }
    }

}
