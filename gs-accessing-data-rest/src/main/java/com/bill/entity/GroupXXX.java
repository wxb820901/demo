package com.bill.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class GroupXXX {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy="groupXXX", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Person> members;

    public GroupXXX(String groupName) {
        this.groupName = groupName;
    }

    public GroupXXX(){}

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Collection<Person> getMembers() {
        return members;
    }

    public void setMembers(Collection<Person> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "GroupXXX{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
