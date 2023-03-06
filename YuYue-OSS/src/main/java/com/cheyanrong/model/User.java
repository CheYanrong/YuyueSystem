package com.cheyanrong.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User /*extends BaseModel*/implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //策略
    private Integer id;  //普通int有默认值，无法区分；当数据类型不匹配时，转换字符串为null，没有值
   @Column(unique = true)//唯一索引
   @NotEmpty(message = "用户名不能为空",groups = {RegGroup.class})
   @Pattern(regexp = "^(\\w{1,10})$",message = "用户名的长度是1-10位",groups = {RegGroup.class})
    private String name;
   @NotEmpty(message = "密码不能为空",groups = {RegGroup.class})
   @Length(min = 6,max = 32,message = "密码长度是6-12位",groups = {RegGroup.class})
    private String password;  //密文 MD5
    @Column(unique = true)
    @NotEmpty(message = "电话号不能为空",groups = {RegGroup.class})
    @Pattern(regexp = "^(\\d{11,13})",message = "密码长度是11-13位",groups = {RegGroup.class})
    private String phone;

    @Column(unique = true)
    @NotEmpty(message = "邮箱不能为空",groups = {RegGroup.class})
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",
            message = "您的邮箱格式不正确",groups = {RegGroup.class})

    private String mail;
    @ManyToMany
    private Set<Role> roles;

    public User(String name, String password, String phone, String mail) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.mail = mail;

    }
//    public User(Integer id) {
//        this.id = id;
//    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
