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
ENV workdir /app/

# 下面的 jar 包可替换为您的 Spring Cloud 应用 jar包，注意这个 jar 包要和您的 dockerfile 位于同一级目录
ENV jar SCG-1.46.17-SpringCloud2021-RELEASE.jar
COPY ${jar} ${workdir}
WORKDIR ${workdir}

# JAVA_OPTS 环境变量的值为部署组的 JVM 启动参数，在运行时 bash 替换。使用 exec 以使 Java 程序可以接收 SIGTERM 信号。
# 考虑到容器场景对于内存的要求，建议添加-Xshare:off选项关闭CDS功能
CMD ["sh", "-ec", "exec java ${JAVA_OPTS} -Xshare:off -jar ${jar}"]