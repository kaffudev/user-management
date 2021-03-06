package com.jfka.um.persistence.model;

import com.jfka.common.interfaces.INameableDto;
import com.jfka.common.persistence.model.INameableEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Role implements INameableEntity, INameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRIV_ID", referencedColumnName = "PRIV_ID") })
    private Set<Privilege> privileges;

    public Role() {
        super();
    }

    public Role(final String nameToSet) {
        super();
        name = nameToSet;
    }

    public Role(final String nameToSet, final Set<Privilege> privilegesToSet) {
        super();
        name = nameToSet;
        privileges = privilegesToSet;
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

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(final Set<Privilege> privilegesToSet) {
        privileges = privilegesToSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name) && Objects.equals(privileges, role.privileges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, privileges);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
            .append("name", name)
            .toString();
    }

}
