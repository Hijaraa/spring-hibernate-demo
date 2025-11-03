# TP 5 : Intégration de Spring et Hibernate

## Description du Projet
Ce projet est une démonstration de l'intégration de Spring Framework avec Hibernate ORM pour la gestion des données. Il illustre comment utiliser ces deux technologies ensemble pour créer une application Java qui interagit avec une base de données relationnelle.

## Technologies Utilisées
- **Spring Framework 5.3.22** - Pour l'injection de dépendances et la gestion des transactions
- **Hibernate 5.6.12** - Pour le mapping objet-relationnel (ORM)
- **MySQL 8.0** - Comme système de gestion de base de données
- **Maven** - Pour la gestion des dépendances et la construction du projet
- **Lombok** - Pour réduire le code boilerplate
- **H2 Database** - Pour les tests unitaires

## Structure du Projet
- **entities** - Contient les classes d'entités JPA (Product)
- **dao** - Contient les interfaces DAO (IDao)
- **metier** - Contient les implémentations des interfaces DAO (ProductDaoImpl)
- **util** - Contient les classes utilitaires (HibernateConfig)

## Configuration
La configuration de la base de données et d'Hibernate se trouve dans le fichier `application.properties`:
```properties
# Configuration MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/base?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# Configuration Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Comment Exécuter le Projet
1. Assurez-vous que MySQL est installé et en cours d'exécution
2. Créez une base de données nommée `base`
3. Modifiez les informations de connexion dans `application.properties` si nécessaire
4. Exécutez la classe `Presentation2` pour voir l'application en action

## Tests
Le projet inclut plusieurs tests unitaires qui vérifient le bon fonctionnement de l'application :
- `AppTest` - Test de base pour vérifier la configuration JUnit
- `TestHibernate` - Vérifie que la configuration Hibernate est correcte
- `ProductDaoTest` - Teste toutes les opérations CRUD sur l'entité Product

Les tests utilisent une base de données H2 en mémoire, ce qui permet de les exécuter sans avoir besoin d'une base de données MySQL. La configuration de test se trouve dans le fichier `src/test/resources/application.properties`.

Pour exécuter les tests :
```bash
mvn test
```

## Fonctionnalités
- Création, lecture, mise à jour et suppression (CRUD) d'entités Product
- Gestion automatique des transactions avec Spring
- Mapping objet-relationnel avec Hibernate