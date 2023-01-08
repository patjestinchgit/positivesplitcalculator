FROM postgres:latest
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB db_positive_split_caclulator

EXPOSE 5432/TCP

COPY setupscript.sql /docker-entrypoint-initdb.d/
COPY /_script/_udpatescripts/type_curves_202301081931.sql /docker-entrypoint-initdb.d/