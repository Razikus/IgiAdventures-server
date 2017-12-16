docker build -t razikus/igiserver .

docker rm -f igiserver

docker run -e MYSQL_HOST=mysql -e MYSQL_PORT=3306 -e MYSQL_USER=igi -e MYSQL_PASSWORD=scores --network=igis -p 8080:8080 --name igiserver -d razikus/igiserver
