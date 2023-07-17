#!/usr/bin/env bash
set -xe
IFS=$'\n\t'

docker compose -f docker-compose.yml -p food "$@"
