SHELL := /bin/bash

windows_database_ip = $(shell docker-machine ip default)
linux_database_ip = localhost

ifeq (${OS},windows)
  database_ip=$(windows_database_ip)
else
  database_ip=$(linux_database_ip)
endif

start:
		mvn liquibase:dropAll -Ddatabase.ip=$(database_ip) -e
		mvn liquibase:update -Ddatabase.ip=$(database_ip) -e
		mvn package -Ddatabase.ip=$(database_ip) -e

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
