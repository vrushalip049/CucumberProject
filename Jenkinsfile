pipeline {
    agent any
     environment {
    TAG = "my-app:${env.BUILD_NUMBER}"
  }
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
        docker { image "${TAG}" }
      }
      steps {
        script {
          docker.build("${TAG}")
          docker.image("${TAG}").inside {
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