FROM mysql:5.7.21
LABEL maintainer="Evgeniy Roldukhin<evgeniy@roldukhin.ru>"

COPY . db

RUN cp db/scripts/create_database.sql /docker-entrypoint-initdb.d/0_create_database.sql

EXPOSE 3306

CMD ["mysqld"]
