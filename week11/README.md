#For dockerfile
1. Create network:
   `docker network create neobis-network`

2. Build MySQL container:
```
cd .\mysql_docker\
docker image build -t mysqldb-image .
```

3. Run container:
   `docker container run -d --net neobis-network -v mysql-storage:/var/lib/mysql --name mysqldb mysqldb-image`

4. Create Database:
```
docker container exec -it mysqldb bash
```
In bash:
```
mysql -uroot -p < create.sql 
```

Then `exit`

5. Create JAR file:
```
cd ..
mvn clean package
```

6. Build application container:
   `docker image build -t api-spring-boot .`

7. Run container:
   `docker container run -p 8082:8082 --net neobis-network --name api-service api-spring-boot`

8. Ready


#For docker-compose

1. Run docker-compose
   `docker-compose up --build`

2. Ready

