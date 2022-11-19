# Magazyn apteki szpitalnej
## Wymagania:
- Java 17
- Maven

```shell
git clone https://github.com/hubigabi/medicine-magazine.git
cd medicine-magazine
```

## Uruchomienie backendu 
```shell
cd medicine-magazine-backend
mvn spring-boot:run
```
Po wystartowaniu webserwisu dane dotyczące leków będą dostępne pod następującym endpointem:
http://localhost:8080/api/medicines

## Uruchomienie frontendu
```shell
cd medicine-magazine-frontend
mvn exec:java
```

## Demo
![Demo 1](/img/demo)
