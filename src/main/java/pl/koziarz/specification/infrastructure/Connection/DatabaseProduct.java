package pl.koziarz.specification.infrastructure.Connection;

import bitronix.tm.resource.jdbc.PoolingDataSource;

import java.util.Properties;

public enum DatabaseProduct {

    H2(
        new DataSourceConfiguration() {
            @Override
            public void configure(PoolingDataSource ds, String connectionURL) {
                ds.setClassName("org.h2.jdbcx.JdbcDataSource");

                // External instance: jdbc:h2:tcp://localhost/mem:test;USER=sa
                ds.getDriverProperties().put(
                    "URL",
                    connectionURL != null
                        ? connectionURL :
                        "jdbc:h2:mem:test"
                );

                ds.getDriverProperties().put("user", "sa");

            }
        },
            org.hibernate.dialect.H2Dialect.class.getName()
    );

    public DataSourceConfiguration configuration;
    public String hibernateDialect;

    private DatabaseProduct(DataSourceConfiguration configuration,
                            String hibernateDialect) {
        this.configuration = configuration;
        this.hibernateDialect = hibernateDialect;
    }

    public interface DataSourceConfiguration {

        void configure(PoolingDataSource ds, String connectionURL);
    }

}
