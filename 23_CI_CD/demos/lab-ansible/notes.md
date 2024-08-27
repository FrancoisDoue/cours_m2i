```yaml
---
- name: Test
  hosts: all
  become: true
  tasks:
    - name: check connexion
      ping: 
    - name: Création du répertoire /tmp/moi
      ansible.builtin.file:
        path: /tmp/moi
        state: directory
        owner: root
    # - name: Message debug
    #   debug: 
    #     msg: "Hello {{ var1 }}"

    # - name: nettoyage du cache avec module apt
    #   apt: 
    #     update_cache: true
    #     cache_valid_time: 3600
    - name: copy files
      vars:
        files:
          - { source: "./send_text/test1.txt", destination: "/tmp/moi/cp_test1.txt", mode: "755", owner: "test" }
          - { source: "./send_text/test2.txt", destination: "/tmp/moi/cp_test2.txt", mode: "644", owner: "test" }
          - { source: "./send_text/test3.txt", destination: "/tmp/moi/cp_test3.txt", mode: "644", owner: "test" }
      copy:
        src: "{{item.source}}"
        dest: "{{item.destination}}"
        mode: "{{item.mode}}"
        owner: "{{item.owner}}"
      with_items:
        - "{{files}}"
  

- name: webserver - create apache directories and username
  hosts: webserver
  become: true
  tasks:
    - name: create group users
      group: 
        name: users
        state: present
    - name: create group users
      group: 
        name: admin
        state: present
    - name: create username apacheadm
      user: 
        name: apacheadm
        groups: users,admin
        append: true
        home: /home/apacheadmin

    - name: install apache2
      apt:
        name: apache2
        state: latest
- name: dbserver - create user directories and username
  hosts: dbserver
  become: true
  tasks:
    - name: Create username for user
      user:
        name: utilisateur
        group: users
        append: true
        home: /home/tomcat
    - name: create directory for apache tomcat
      file:
        path: /opt/oracle
        owner: utilisateur
        group: users
        state: directory
        mode: 0755
```