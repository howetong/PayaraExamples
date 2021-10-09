package org.howe.examples.jpa.entity;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Factory for Entity Manager.
 */
public class EntityManagerFactory {

    @PersistenceContext(unitName = "SAMPLE_PU")
    private EntityManager entityManager;

    /**
     * Get the entity manager.
     *
     * @return The entity manager.
     */
    @Produces
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
