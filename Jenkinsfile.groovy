pipeline {
    agent any
    stages {
        stage('Checkout from Repo') {
            steps {
                checkout scm: [
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        credentialsId: 'github-key', 
                        url: 'git@github.com:fiachrah/SoftwareEngineeringAssignment1A.git']]
                        ]
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('JUnit Tests') {
           steps {
                sh './gradlew test'
            }
        }
    }
}
