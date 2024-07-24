```bash
# Création d'un volume nommé 
docker volume create cactus

# Création d'un conteneur serveur web avec nginx et utilisation du volume cree pour stocker votre site web.
docker run -v cactus:/usr/share/nginx/html --name nginx-cactus -p 8080:80 -d nginx
docker cp .\Desktop\exo_cactus.zip nginx-cactus:/usr/share/nginx/html
docker exec -it nginx-cactus /bin/bash
    apt install unzip
    cd /usr/share/nginx/html
    unzip exo_cactus.zip
    rm exo_cactus.zip
    mv exo_cactus/* ./
    exit
# confirmation via votre navigateur 
# suppression de votre conteneur nginx
stop nginx-cactus
docker rm nginx-cactus

# Création d'un conteneur serveur web avec apache qui utilisera le site web présent dans votre volume.
docker run -v cactus:/usr/local/apache2/htdocs/ --name httpd-cactus -p 8080:80 -d httpd
docker run -v cactus:/usr/share/caddy/ -p 5678:80 --name caddy-cactus -d caddy

```
