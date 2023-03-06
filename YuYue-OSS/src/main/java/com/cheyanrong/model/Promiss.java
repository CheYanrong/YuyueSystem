package com.cheyanrong.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Promiss implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //策略
    private Integer id;  //普通int有默认值，无法区分；当数据类型不匹配时，转换字符串为null，没有值
    private String name;
    private String icon;
    private String path;
    @ManyToOne
    private Promiss parent;
    @OneToMany(mappedBy = "parent")
    private Set<Promiss> children;

    public Promiss(String name, String icon, String path,Promiss parent) {

        this.name = name;
        this.icon = icon;
        this.path = path;
        this.parent = parent;
    }
}
