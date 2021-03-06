package org.ikora.inspector.model;

import javax.persistence.*;

@Entity
@Table(name = "clone_type")
public class CloneTypeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    protected CloneTypeEntity() {}

    public CloneTypeEntity(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("CloneType[id=%d, name=%s, description=%s]", id, name, description);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
