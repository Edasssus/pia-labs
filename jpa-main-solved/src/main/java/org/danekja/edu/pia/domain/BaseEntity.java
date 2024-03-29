package org.danekja.edu.pia.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Base interface for all entities to make implementation of generic dao easier.
 *
 * PK type represents type of the entity's primary key.
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
@MappedSuperclass
public abstract class BaseEntity<PK extends Serializable> implements  IEntity<PK> {

    protected PK id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Override
    @Transient
    public PK getPK() {
        return getId();
    }

    public abstract String toString();

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}
