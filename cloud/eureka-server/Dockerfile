FROM openjdk:8
ENV TZ=Asia/Shanghai
RUN mkdir /app
WORKDIR /app
ADD target/eureka-server.zip /app/
RUN unzip /app/eureka-server.zip && rm -f /app/eureka-server.zip
CMD cd /app/eureka-server && java -cp "./conf:lib/*" com.trennble.eureka.EurekaServerApplication
