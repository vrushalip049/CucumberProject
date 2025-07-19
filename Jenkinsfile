pipeline {
  agent any
  environment {
    TAG = "my-app:${env.BUILD_NUMBER}"
  }
  stages {
    stage('Checkout') {
      steps { git 'https://github.com/vrushalip049/CucumberProject.git' }
    }
    stage('Build & Package Docker Image') {
      steps {
        script {
          bat "docker build -t ${env.TAG} ."
        }
      }
    }
    stage('Test Inside Docker') {
      steps {
        bat "docker run --rm ${env.TAG} mvn test"
      }
    }
    stage('Archive Artifact') {
      steps {
        script {
          bat """
            docker create --name tmp ${env.TAG}
            docker cp tmp:/app/app.jar target/
            docker rm tmp
          """
        }
        archiveArtifacts artifacts: 'target/app.jar', fingerprint: true
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
