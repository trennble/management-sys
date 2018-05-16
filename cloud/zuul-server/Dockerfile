FROM openjdk:8
ENV TZ=Asia/Shanghai
RUN mkdir /app
WORKDIR /app
ADD target/zuul-server.zip /app/
RUN unzip /app/zuul-server.zip && rm -f /app/zuul-server.zip
CMD cd /app/zuul-server && java -cp "./conf:lib/*" com.trennble.zuul.ZuulServerApplication
