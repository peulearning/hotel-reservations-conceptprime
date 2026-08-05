# Estágio 1: Build da aplicação usando Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom e baixa as dependências primeiro (aproveita cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e faz o build pulando os testes para ser mais rápido
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Imagem final para execução
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copia apenas o arquivo .jar gerado no Estágio 1
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
