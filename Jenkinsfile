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
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
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