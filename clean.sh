#!/usr/bin/env bash
sudo docker rm -f $(sudo docker ps -a -q)
sudo docker rmi $(sudo docker images | grep "^<none>" | awk "{print $3}")
sudo docker rmi $(sudo docker images | grep "axele" | awk "{print $3}")
sudo docker images
