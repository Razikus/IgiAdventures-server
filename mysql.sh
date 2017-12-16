docker run --name mysql -e MYSQL_ROOT_PASSWORD=test --network=igis -e MYSQL_DATABASE=igiscores -e MYSQL_USER=igi -e MYSQL_PASSWORD=scores -d mysql:latest
