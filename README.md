# hibernate-config
hibernate.properties

        # session factory
        scan.classes=com.test.*
        # data source
        db.driver.class.name=com.mysql.jdbc.Driver
        db.url=jdbc:mysql://localhost:3306/db
        db.userName=root
        db.password=root
        # hibernate
        hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
        hibernate.show_sql = true
        hibernate.format_sql = true
        hibernate.connection.pool_size=10
        # hibernate cache
        hibernate.cache.use_structured_entries=true
        hibernate.cache.use_second_level_cache=true
        hibernate.cache.use_query_cache=true
        hibernate.cache.region.provider_class=org.hibernate.cache.EhCacheProvider
        hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
        
   * add to pom connector-j depends on driver name class
