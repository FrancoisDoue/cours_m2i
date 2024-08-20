Command lines

```sh
# install quarkus CLI with chocolatey
choco install quarkus

# create a new quarkus project
mvn quarkus:create-app -DprojectGroupId=com.example -DprojectArtifactId=my-quarkus-app
quarkus create app com.example:my-quarkus-app

# add extensions
mvn quarkus:add-extension -Dextension="resteasy,hibernate-orm"


```