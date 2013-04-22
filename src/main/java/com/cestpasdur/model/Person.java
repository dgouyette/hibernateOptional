package com.cestpasdur.model;

import fj.data.Option;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;


    @Column
    @Type(type="com.cestpasdur.usertype.StringOptionType")
    private Option<String> email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Option<String> getEmail() {
        return email;
    }

    public void setEmail(Option<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
