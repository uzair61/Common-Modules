FROM openjdk:8-jre-alpine

WORKDIR /home

COPY target/product-1.0.jar .

COPY docker-entrypoint.sh docker-entrypoint.sh

RUN chmod +x /home/docker-entrypoint.sh

EXPOSE 9000

ENTRYPOINT ["/home/docker-entrypoint.sh"]
CMD ["product-1.0.jar"]