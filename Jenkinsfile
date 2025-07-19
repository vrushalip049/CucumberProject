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

    stage('Build, Test & Package in Docker') {
      steps {
        script {
          // Build the Docker image using the Dockerfile in repo
          bat "docker build -t ${env.TAG} ."
          
          // Run tests and package inside the container
          bat """
            docker run --rm ^
              ${env.TAG} ^
              mvn clean package -DskipTests && mvn test
          """
        }
      }
    }

    stage('Archive Artifact') {
      steps {
        // Copy the built JAR from the container to workspace
        script {
          bat """
            docker create --name tmp_container ${env.TAG}
            docker cp tmp_container:/workspace/target/ ./
            docker rm tmp_container
          """
        }
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
