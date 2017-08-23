Save JSON to MySQL using Hibernate 
===

This is an example how to save JSON to a MySQL database (version > 5.7) using Hibernate.

For this, a custom Hibernate [UserType](http://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/usertype/UserType.html) needs to be implemented. In order to serialize a Java object
to JSON (or to deserialize JSON to a Java object) Jackson library is used.
In order to be able to save more than only one type of JSON, 
the custom UserType also implements Hibernate's [ParameterizedType](http://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/usertype/ParameterizedType.html). This allows 
to specify the type using Hibernate's [Parameter](http://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/annotations/Parameter.html) annotation.

Integrations are performed using [Maven Failsafe Plugin](http://maven.apache.org/surefire/maven-failsafe-plugin/). [Docker maven plugin](https://github.com/fabric8io/docker-maven-plugin) 
allows to build Docker images and, hence, perform the integration test on a real database.

