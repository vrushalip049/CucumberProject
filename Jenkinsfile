pipeline {
  agent any
  environment {
    TAG = "my-app:${env.BUILD_NUMBER}"
  }
  tools {
    maven 'Maven'
  }
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/vrushalip049/CucumberProject.git'
      }
    }
    stage('Build & Test (Host)') {
      steps {
        bat 'mvn clean test'
      }
    }
    stage('Build Docker Image') {
      steps {
        script {
          // Build the Docker image
          bat "docker build -t ${TAG} ."
        }
      }
    }
    stage('Test Inside Docker') {
      steps {
        script {
          // Convert Windows-style workspace path (e.g., C:\... ) to Unix-style (/c/...)
          def winPath = pwd().replaceAll('\\\\', '/').replaceFirst(/^([A-Za-z]):/) { "/${it[1].toLowerCase()}" }
          bat """
            docker run --rm ^
              -v ${winPath}:/workspace ^
              -w /workspace ^
              ${TAG} ^
              mvn clean test
          """
        }
      }
    }
    stage('Package & Archive') {
      steps {
        bat 'mvn clean package'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    stage('Publish Cucumber Reports') {
      steps {
        cucumber buildStatus: 'UNSTABLE',
                 fileIncludePattern: '**/cucumber.json',
                 sortingMethod: 'ALPHABETICAL'
      }
    }
  }
}
