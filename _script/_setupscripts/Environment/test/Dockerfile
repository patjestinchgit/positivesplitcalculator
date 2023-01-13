FROM ubuntu:latest

ENV DEBIAN_FRONTEND=noninteractive


RUN DEBIAN_FRONTEND=noninteractive \
      apt-get update \
      && apt-get install -y postgresql postgresql-contrib \
      && rm -rf /var/lib/apt/lists/*
      ## addUser adminUbuntuMachine sudo passwd password
## TODO: add Jenkins system https://github.com/jenkinsci/docker/blob/master/README.md! Add these instructions to the Dockerfile FF



