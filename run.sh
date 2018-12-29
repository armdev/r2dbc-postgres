#!/usr/bin/env bash

mvn -f dbsetup clean package -U -Dmaven.test.skip=true
sudo docker-compose up -d --build


