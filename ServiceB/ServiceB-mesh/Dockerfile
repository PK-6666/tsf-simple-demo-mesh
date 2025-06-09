# 替换成自己的基础镜像和JDK版本
FROM centos:7
#安装 KonaJDK
ADD TencentKona8.0.8.b1_jdk_linux-x86_64_8u312.tar.gz /data/bin
ENV JAVA_HOME /data/bin/TencentKona-8.0.8-312
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV PATH $PATH:$JAVA_HOME/bin

# 设置时区。这对于日志、调用链等功能能否在 TSF 控制台被检索到非常重要。
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

RUN mkdir /root/app/
# 其中 userService.tar.gz 是 Mesh 应用压缩包
ADD ServiceB.tar.gz /root/app/

# 指定到jar的当前目录执行
WORKDIR /root/app/ServiceB

ENTRYPOINT ["bash", "start.sh"]

