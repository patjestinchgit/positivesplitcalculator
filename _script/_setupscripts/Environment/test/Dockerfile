FROM ubuntu:latest

ENV DEBIAN_FRONTEND=noninteractive

RUN DEBIAN_FRONTEND=noninteractive \
      apt-get update \
      && apt-get install -y postgresql postgresql-contrib \
      && rm -rf /var/lib/apt/lists/* \
RUN DEBIAN_FRONTEND=noninteractive \
    addUser adminUbuntuMachine sudo passwd password \




