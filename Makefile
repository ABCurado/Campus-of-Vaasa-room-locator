SHELL := /bin/bash

app:
	mvn package -e

migrations:
	mvn liquibase:update -e

start-local-db:
	docker run -p 3306:3306 --name mapp-sql-database \
		-e MYSQL_USER=mapp-database-user \
		-e MYSQL_PASSWORD=mapp-database-passwd \
		-e MYSQL_DATABASE=mapp_sql_database \
		-e MYSQL_RANDOM_ROOT_PASSWORD=yes -d mysql:latest

stop-local-db:
	docker stop mapp-sql-database && docker rm mapp-sql-database

start:
	mvn liquibase:dropAll -e
	mvn liquibase:update -e
	mvn package -e
	
