## 1 - Renommer le fichier .env.exemple ==> .env

## 2 - Lancer les containers

```sh
docker-compose up -d
```

## 3 - Se connecter au container ansible

```sh
docker exec -it ansible bash
```

## 4 - Mettre à jour l'ubuntu

```sh
apt update
```

## 5 - Installer ansible

```sh
apt install ansible
```

## 6 - Vérifier l'installation d'ansible

```sh
ansible --version
```

