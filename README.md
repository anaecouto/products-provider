# Welcome to products-provider! 🧲

> Gradle-based project. This project's goal is to extract data from an excel sheet (precos-ribeirao-preto.xlsx) containing the most varied products and their respective barcodes and send them to Kafka through a DTO so they can be consumed by the supermarket-rpa.

## Use docker to start kafka broker

In your terminal, input the following command:

```sh
docker-compose up -d
```

After application has started, make an POST request to the following endpoint:
```sh
localhost:8080/products?zipCode={zipCode_here}
```

The endpoint receives a query param zipCode where you can input any valid zip code in it.

## Server is ready to run!

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#using-boot-devtools)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* Project's author: @anaecouto

