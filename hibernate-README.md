
## Hibernate Architecture:

```
-------------------------------------------------------------------------
|  -------------------------------------------------------              |
| |                     Transaction                       |             |
|  -------------------------------------------------------              |
|  -------------------------                                            |
| |      SessionFactory     |     -------------                         |
| |JPA-EntityManagerFactory | -> |Configuration|                        |
|  -------------------------     -------------                          |
|            |                                                          |
|  -----------------                          -----------               |
| |     Session     |      -------------     |First-Level|              |
| |JPA-EntityManager|  -> |Query (API's)| -> |   Cache   |  -> Database |
|  -----------------       -------------      -----------               |
|                                              per session              |
-------------------------------------------------------------------------
    Secondary-Level
        Cache 
     (EH Cache/ per session factory)
- Hibernate doesn't have implementation, but provides integration where we have to pass the SecondaryLevelCacheProvider.
- Second level cache is associated with SessionFactory and is shared accross multiple sessions
```
- Hibernate doesn't provide implementation of secondary level cache mechanism, but it provides integration where we have to pass the SecondaryLevelCacheProvider.
- Java Persistence API is the specification for persisting the objects into database.

###### JPA (Java Persistent API) :

- Configurations
> Configurations are required information or meta data for JDBC to setup a connection to database. <br>
> - META-INF/persistence.xml -> JPA configuration file <br>
> - PersistenceUnitInfo interface -> Java class based configuration

- EntityManagerFactory - SessionFactory 
> EntityManagerFactory provides EntityManager

- EntityManager - Session 
> EntityManager/Session provides API's for domain models to persist, merge, remove etc

- Transaction 
> Transactions help in maintaining the data integrity, by providing APIs such as commit and rollback.

- First-Level Cache (Persistence Context)
> First level cache is implemented by hibernate, caches data per session.

- Second-Level Cache 
> Hibernate doesn't provide implementation of secondary level cache mechanism, but it provides integration where we have to pass the SecondaryLevelCacheProvider.

###### Hibernate ORM (Java Persistent API Provider) :

- Configurations
> Configurations are required information or meta data for JDBC to setup a connection, Declare mappings of classes and class properties to a tables in the database. <br>
> - hibernate.properties <br>
> - hibernate.cfg.xml <br>
> - Java @Configuration Annotation <br>

- Configuration 
- SessionFactory 
- Session 
- Transaction 