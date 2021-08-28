package pl.koziarz.specification.infrastructure.Connection;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Creates an EntityManagerFactory.
 * <p>
 * Configuration of the persistence units is taken from <code>META-INF/persistence.xml</code>
 * and other sources. Additional <code>hbm.xml</code> file names can be given to the
 * constructor.
 * </p>
 */
public class JPASetup {

    protected final String persistenceUnitName;
    protected final Map<String, String> properties = new HashMap<>();
    protected final EntityManagerFactory entityManagerFactory;

    public JPASetup(String persistenceUnitName ) throws Exception {

        this.persistenceUnitName = persistenceUnitName;


        properties.put(
            "hibernate.format_sql",
            "true"
        );
        properties.put(
            "hibernate.use_sql_comments",
            "true"
        );

        entityManagerFactory =
            Persistence.createEntityManagerFactory(getPersistenceUnitName());
        dropSchema();

        createSchema();
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public void createSchema() {
        generateSchema("create");
    }

    public void dropSchema() {
        generateSchema("drop");
    }

    public void generateSchema(String action) {
        // Take exiting EMF properties, override the schema generation setting on a copy
        Map<String, String> createSchemaProperties = new HashMap<>(properties);
        createSchemaProperties.put(
            "javax.persistence.schema-generation.database.action",
            action
        );
        Persistence.generateSchema(getPersistenceUnitName(), createSchemaProperties);
    }
}
