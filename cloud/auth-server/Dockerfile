FROM openjdk:8
ENV TZ=Asia/Shanghai
RUN mkdir /app
WORKDIR /app
ADD target/auth-server.zip /app/
RUN unzip /app/auth-server.zip && rm -f /app/auth-server.zip
CMD cd /app/auth-server && java -cp "./conf:lib/*" com.trennble.auth.AuthServerApplication
