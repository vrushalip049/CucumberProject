pipeline {
    agent any
    tools {
        maven 'Maven' // Name configured in Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vrushalip049/CucumberProject.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Build & Test in Docker') {
      agent {
        docker { image '"mycompany/my-app:latest"' }
      }
      steps {
        script {
          docker.build("mycompany/my-app:latest")
          docker.image("mycompany/my-app:latest").inside {
            bat 'mvn clean test'
          }
        }
      }
    }
         stage('Archive Artifacts') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    
        stage('Publibat Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                         fileIncludePattern: '**/cucumber.json',
                         sortingMethod: 'ALPHABETICAL'
            }
        }
    }
}