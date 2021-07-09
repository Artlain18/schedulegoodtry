package com.company.schedulegoodtry.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "SCHEDULEGOODTRY_BANK")
@Entity(name = "schedulegoodtry_Bank")
@NamePattern("%s|name")
public class Bank extends StandardEntity {
    private static final long serialVersionUID = -453180802500640729L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "bank")
    private List<Client> clientList;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "bank")
    private List<Credit> listCredit;

    public List<Credit> getListCredit() {
        return listCredit;
    }

    public void setListCredit(List<Credit> listCredit) {
        this.listCredit = listCredit;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}