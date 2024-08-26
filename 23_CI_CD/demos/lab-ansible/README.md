# **Ansible**

## **Description**

Lab pour apprendre Ansible.

Comporte :

- un conteneur avec Ansible
- des noeuds Debian

## **Prérequis**

1. docker
2. docker-compose
3. VScode ou autre
4. vim ou nano

## **Extensions VScode**

1. [plugin docker](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-docker)
2. [plugin ansible](https://marketplace.visualstudio.com/items?itemName=redhat.ansible)

## **Découpage du projet**

- docker-compose.override.yml : contient le réseau et le conteneur avec Ansible
- docker-compose.yml : contient les noeuds
- .env : contient les versions

## **Notes**

Documentations :

- [Rappel commandes docker](https://dockerlabs.collabnix.com/docker/cheatsheet/)
- [Rappel commandes docker-compose](https://devhints.io/docker-compose)
- [Réseaux Docker](https://blog.alphorm.com/reseau-docker-partie-1-bridge/)
- [Documentation Jinja 3](https://jinja.palletsprojects.com/en/3.0.x/)

Ansible :

- [Le fichier ansible.cfg peut être déplacé](https://stackoverflow.com/a/35969858/8502023)
