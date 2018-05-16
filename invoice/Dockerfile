FROM openjdk:8
ENV TZ=Asia/Shanghai
RUN mkdir /app
WORKDIR /app
ADD target/invoice-server.zip /app/
RUN unzip /app/invoice-server.zip && rm -f /app/invoice-server.zip
CMD cd /app/invoice-server && java -cp "./conf:lib/*" com.trennble.invoice.InvoiceApplication
