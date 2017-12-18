前提：在本机中安装docker

1. 在pom中增加docker插件 docker-maven-plugin
2. mvn clean package docker:build
3. docker run -it -P spring-boot-docker-start
4. docker ps 查看本机的哪个端口映射到了容器的8080端口，例如是32768
   CONTAINER ID        IMAGE                      COMMAND                  CREATED             STATUS              PORTS                     NAMES
   2e2c1d30f0e6        spring-boot-docker-start   "java -jar /spring..."   9 seconds ago       Up 8 seconds        0.0.0.0:32768->8080/tcp   flamboyant_swirles
5. http://localhost:32768/hello,返回hello world,表示成功。