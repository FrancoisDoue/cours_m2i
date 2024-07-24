```bash
# En utilisant votre machine Windows, lancez le service Docker, s’il n’est pas lancé.

# Créer une image Docker sur votre machine du jeu 2048 (voir screen jeux_2048).
docker search 2048
docker pull kubespheredev/2048

# Vérifier que l’image est bien présente sur votre machine.
docker images

# Lancer ce jeu sur un port disponible au travers d’un conteneur que vous allez appeler «jeu-votre-nom ». 
docker run --name jeu-francois -p 8080:80 -d kubespheredev/2048

# Vérifier que le conteneur est bien lancé avec la commande adaptée.
docker ps

# Créer un second conteneur qui va lancer le même jeu mais avec un nom différent «jeu2-votre-nom ».
docker run --name jeu2-francois -p 8081:80 -d kubespheredev/2048

# Les 2 jeux sont fonctionnels en même temps sur votre machine, effectuez la commande pour vérifier la présence des conteneurs.
docker ps

# Ouvrez les 2 jeux sur votre navigateur. 

# Stopper les 2 conteneurs et assurez-vous que ces 2 conteneurs sont arrêtés.
docker stop jeu-francois jeu2-francois

# Relancez le conteneur «jeu2-votre-nom » et aller vérifier dans votre navigateur s’il fonctionne bien. Effectuez la commande pour voir s’il a bien été relancé. Puis stopper le. 
docker start jeu2-francois
docker stop jeu2-francois

# Supprimez l’image du jeu 2048 et les conteneurs associés.
docker rm jeu2-francois jeu-francois
docker rmi kubespheredev/2048

# Vérifiez que les suppressions ont bien été faite.
docker ps
docker images

####################################################################################################################

# Récupérer une image docker nginx.
docker search nginx
docker pull nginx

# Créer un conteneur en vous basant sur cette image en lui attribuant le nom suivant : « nginx-web».
docker run --name nginx-web -p 8080:80 -d nginx

# Assurez-vous que l’image est bien présente et que le conteneur est bien lancé.
docker images
docker ps
# Ce serveur nginx web (nginx-web) devra être lancé sur un port disponible.
# Vérifier que le serveur est bien lancé au travers du navigateur.
# Une page web avec «Welcome to nignx » devrait s'afficher (voir nginx.png). 

# Effectuer la commande vous permettant de rentrer à l’intérieur de votre serveur nginx.
docker exec -it nginx-web sh

# Une fois à l’intérieur, aller modifier la page html par défaut de votre serveur nginx en changeant le titre de la page en : Welcome «votre prenom ».
apt update
apt install nano -y
cd usr/share/nginx/html
nano index.html

exit

# Relancez votre serveur et assurez-vous que le changement à bien été pris en compte, en relançant votre navigateur.
# Refaite la même opération mais en utilisant le serveur web apache et donc il faudra créer un autre conteneur.

docker pull httpd
docker run --name httpd-web -p 8081:80 -d httpd


# Il faut supprimer le contenu complet de l'index.html et y mettre : "Je suis heureux et je m'appelle votre prenom".
docker exec -it httpd-web sh
apt update
apt install nano
cd htdocs
nano index.html

exit

# Le changement doit appaître dans votre navigateur.

####################################################################################################################

# Répétez 3 fois la même opération que pour le début de la partie 2, il faudra juste appelez vos conteneurs :
# « nginx-web3 ».
docker run --name nginx-web3 -p 8083:80 -d nginx
# « nginx-web4 ».
docker run --name nginx-web4 -p 8084:80 -d nginx
# « nginx-web5 ».
docker run --name nginx-web5 -p 8085:80 -d nginx

# Il faudra faire en sorte que les pages html présente dans les fichiers ci-dessous s’affiche dans chacun des navigateurs en lien avec vos conteneurs :

# html5up-editorial-m2i.zip pour nginx-web3
docker cp .\Desktop\html5up-editorial-m2i.zip nginx-web3:/usr/share/nginx/html
docker exec -it nginx-web3 sh
apt update
apt install unzip
cd /usr/share/nginx/html
unzip html5up-editorial-m2i.zip
mv html5up-editorial/* ./
exit

# html5up-massively.zip pour nginx-web4
docker cp .\Desktop\html5up-massively.zip nginx-web4:/usr/share/nginx/html
docker exec -it nginx-web4 sh
apt update
apt install unzip
cd /usr/share/nginx/html
unzip html5up-massively.zip -y
exit

# html5up-paradigm-shift.zip pour nginx-web5
docker cp .\Desktop\html5up-paradigm-shift.zip nginx-web5:/usr/share/nginx/html
docker exec -it nginx-web5 sh
apt update
apt install unzip
cd /usr/share/nginx/html
unzip html5up-paradigm-shift.zip -y
exit

# Stopper, ensuite, ces différents conteneurs.
docker stop nginx-web3 nginx-web4 nginx-web5

```