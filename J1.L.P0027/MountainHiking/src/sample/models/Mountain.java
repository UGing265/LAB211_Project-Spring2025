/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.models;

import java.io.Serializable;

/**
 *
 * @author hoadoan
 */
public class Mountain implements Serializable{
    private String code;
    private String name;
    private String province;
    private String description;

    public Mountain() {
    }

    public Mountain(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
        Mountain mt= (Mountain) obj;
        return this.getCode().equals(mt.getCode());
    }

    public Mountain(String code, String name, String province, String description) {
        this.code = code;
        this.name = name;
        this.province = province;
        this.description = description;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
