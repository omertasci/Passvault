package com.omertasci.passvault.entity;

import com.omertasci.passvault.util.EncryptionUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Table(name = "entry")
@Entity
@Getter
@Setter
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "weblink")
    private String weblink;

    @Column(name = "note")
    private String note;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    public String getPassword() {
        return EncryptionUtil.decrypt(password);
    }
    public void setPassword(String password) {
        this.password = EncryptionUtil.encrypt(password);
//        this.password = password;
    }
}
