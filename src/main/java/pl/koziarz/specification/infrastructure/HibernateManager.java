package pl.koziarz.specification.infrastructure;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionCoordinatorBuilderImpl;
import org.hibernate.service.ServiceRegistry;



public class HibernateManager  {

    protected SessionFactory createSessionFactory() {


        StandardServiceRegistryBuilder serviceRegistryBuilder =
            new StandardServiceRegistryBuilder();

        /* 
            Configure the services registry by applying settings.
         */
        serviceRegistryBuilder
            .applySetting("hibernate.connection.datasource", "H2")
            .applySetting("hibernate.format_sql", "true")
            .applySetting("hibernate.use_sql_comments", "true")
            .applySetting("hibernate.hbm2ddl.auto", "create-drop");

        serviceRegistryBuilder.applySetting(
                Environment.TRANSACTION_COORDINATOR_STRATEGY,
                JtaTransactionCoordinatorBuilderImpl.class
        );
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();


        MetadataSources metadataSources = new MetadataSources(serviceRegistry);





        MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();

        Metadata metadata = metadataBuilder.build();


        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory;


    }

}
