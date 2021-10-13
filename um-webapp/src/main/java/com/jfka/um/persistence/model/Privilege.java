package com.jfka.um.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jfka.common.interfaces.INameableDto;
import com.jfka.common.persistence.model.INameableEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Privilege implements INameableEntity, INameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIV_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Privilege() {
        super();
    }

    public Privilege(final String name, final String description) {
        super();
        this.name = name;
        this.description = description;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long idToSet) {
        id = idToSet;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String nameToSet) {
        name = nameToSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String descriptionToSet) {
        description = descriptionToSet;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> rolesToSet) {
        roles = rolesToSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return Objects.equals(id, privilege.id) && Objects.equals(name, privilege.name) && Objects.equals(description, privilege.description) && Objects.equals(roles, privilege.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, roles);
    }
}
