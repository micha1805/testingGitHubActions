# Demo Spring Boot avec GitHub Actions et Heroku

Cette application de démonstration montre comment configurer un pipeline CI/CD avec GitHub Actions pour une application Spring Boot, avec déploiement automatique sur Heroku.

## Configuration des workflows

L'application utilise trois workflows GitHub Actions différents :

1. **CI (Continuous Integration)**
   - S'exécute sur tous les commits de toutes les branches
   - Vérifie que tous les tests passent

2. **Déploiement Staging**
   - S'exécute uniquement sur la branche `dev`
   - Build l'application
   - Déploie automatiquement sur Heroku (environnement de staging)

3. **Build Master**
   - S'exécute uniquement sur la branche `master`
   - Build l'application
   - Crée un artifact mais ne déploie pas automatiquement

## Prérequis

- Java 17
- Maven
- Un compte Heroku

## Configuration Heroku

1. Créer une nouvelle application sur Heroku pour l'environnement de staging

2. Configurer les secrets GitHub suivants :
   - `HEROKU_API_KEY` : Votre clé API Heroku
   - `HEROKU_EMAIL` : Votre email Heroku
   - `HEROKU_STAGING_APP_NAME` : Le nom de votre application Heroku pour le staging

Pour obtenir votre clé API Heroku :
1. Connectez-vous à votre compte Heroku
2. Allez dans les paramètres de votre compte
3. Faites défiler jusqu'à "API Key" et cliquez sur "Reveal"

## Démarrage rapide

1. Cloner le repository
```bash
git clone [URL_DU_REPO]
```

2. Construire l'application
```bash
mvn clean package
```

3. Lancer l'application localement
```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

4. Accéder à l'application locale
```
http://localhost:8080
```

## Tests

Pour exécuter les tests :
```bash
mvn test
```

## Déploiement manuel sur Heroku

Si vous souhaitez déployer manuellement (en dehors du pipeline automatique) :

1. Installer le CLI Heroku
2. Se connecter à Heroku
```bash
heroku login
```

3. Déployer l'application
```bash
git push heroku main
``` 