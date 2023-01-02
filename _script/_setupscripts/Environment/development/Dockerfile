FROM postgres:latest
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB db_positive_split_caclulator
COPY setupscript.sql /docker-entrypoint-initdb.d/
