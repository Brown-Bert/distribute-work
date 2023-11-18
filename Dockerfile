# 基于官方的Ubuntu 20.04镜像作为基础镜像
FROM ubuntu:20.04

# 设置环境变量
#ENV JDK_VERSION 17
#ENV JDK_HOME /opt/jdk
#ENV PATH $JDK_HOME/bin:$PATH

COPY ./ /usr/server/
# 安装JDK17
RUN apt update && \
    apt install openjdk-17-jdk -y
RUN apt-get update && \
    apt-get install -y curl tar

ENV MAVEN_VERSION 4.0.0-alpha-5
#ENV MAVEN_HOME /opt/maven

RUN curl -fsSL -o /tmp/apache-maven-4.0.0-alpha-5-bin.tar.gz https://dlcdn.apache.org/maven/maven-4/4.0.0-alpha-5/binaries/apache-maven-4.0.0-alpha-5-bin.tar.gz && \
        tar -xzf /tmp/apache-maven-4.0.0-alpha-5-bin.tar.gz -C /opt && \
        mv /opt/apache-maven-4.0.0-alpha-5 /opt/maven
RUN ls /opt/maven
COPY ./settings.xml /opt/maven/conf/
ENV PATH="/opt/maven/bin:$PATH"

RUN mvn --version
RUN mvn clean -f /usr/server/pom.xml
RUN mvn package -f /usr/server/pom.xml
RUN cp /usr/server/target/server.jar /tmp/server.jar
# 配置Java环境变量
#RUN echo "export JAVA_HOME=$JDK_HOME" >> /etc/profile && \
 #   echo "export PATH=$JDK_HOME/bin:$PATH" >> /etc/profile

# 验证JDK安装
RUN java -version

#EXPOSE 9527
ENTRYPOINT java -jar /tmp/server.jar
