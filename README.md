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

3. **Déploiement Production**
   - Déploiement manuel via GitHub Actions
   - S'exécute depuis la branche `master`
   - Nécessite une approbation manuelle

## Environnements

L'application utilise différents profils Spring Boot selon l'environnement :

1. **Test** (`application-test.properties`)
   - Utilisé pour les tests automatisés
   - Logs en mode DEBUG

2. **Staging** (`application-staging.properties`)
   - Déploiement automatique depuis la branche `dev`
   - Logs en mode DEBUG pour le développement

3. **Production** (`application-production.properties`)
   - Déploiement manuel depuis `master`
   - Logs en mode INFO uniquement

Pour vérifier l'environnement actif, accédez à la racine de l'application (`/`). Vous verrez les profils actifs et les profils par défaut.

## Prérequis

- Java 17
- Maven
- Un compte Heroku

## Configuration Heroku

1. Créer deux applications sur Heroku :
   - Une pour l'environnement de staging
   - Une pour l'environnement de production

2. Configurer les secrets GitHub suivants :
   - `HEROKU_API_KEY` : Votre clé API Heroku
   - `HEROKU_EMAIL` : Votre email Heroku
   - `HEROKU_STAGING_APP_NAME` : Le nom de votre application Heroku pour le staging
   - `HEROKU_PRODUCTION_APP_NAME` : Le nom de votre application Heroku pour la production

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

Les tests utilisent un profil dédié qui peut être consulté dans `src/test/resources/application-test.properties`.

## Déploiement manuel sur Heroku

Pour un déploiement en production :
1. Assurez-vous que vos changements sont sur la branche `master`
2. Allez dans l'onglet "Actions" de GitHub
3. Sélectionnez le workflow "Deploy to Production"
4. Cliquez sur "Run workflow"
5. Confirmez le déploiement

Pour un déploiement en staging, il suffit de pousser sur la branche `dev` :