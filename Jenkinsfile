pipeline {
  agent any
  environment {
    IMAGE = "my-app:${env.BUILD_NUMBER}"
  }
  tools {
    maven 'Maven' // from Global Tool Configuration
  }
  stages {
    stage('Checkout & Build') {
      steps {
        git 'https://github.com/vrushalip049/CucumberProject.git'
        bat 'mvn clean install'
      }
    }
    stage('Docker Build') {
      steps {
        script {
          dockerImage = docker.build(IMAGE, '.')
        }
      }
    }
    stage('Test in Docker') {
      steps {
        script {
          // Verify image exists locally
          bat "docker inspect -f . ${IMAGE}"
          // Run tests inside the built container
          dockerImage.inside {
            bat 'mvn test'
          }
        }
      }
    }
    stage('Archive Artifacts') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    stage('Publish Reports') {
      steps {
        cucumber buildStatus: 'UNSTABLE',
                 fileIncludePattern: '**/cucumber.json',
                 sortingMethod: 'ALPHABETICAL'
      }
    }
  }
}
