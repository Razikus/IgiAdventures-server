# IgiAdventures-server

example run: (maaany ways to do it)

```docker network create igis
docker run --name mysql -e MYSQL_ROOT_PASSWORD=test --network=igis -e MYSQL_DATABASE=igiscores -e MYSQL_USER=igi -e MYSQL_PASSWORD=scores -d mysql:latest
docker run -e MYSQL_HOST=mysql -e MYSQL_PORT=3306 -e MYSQL_USER=igi -e MYSQL_PASSWORD=scores --network=igis -p 8080:8080 --name igiserver -d razikus/igiserver```
