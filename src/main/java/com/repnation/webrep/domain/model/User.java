package com.repnation.webrep.domain.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user")
    private Set<TrashEntry> trashEntries;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void addTrashEntry(TrashEntry entry) {
        trashEntries = trashEntries!=null?trashEntries:new HashSet<>();
        trashEntries.add(entry);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TrashEntry> getTrashEntries() {
        return trashEntries;
    }
}
