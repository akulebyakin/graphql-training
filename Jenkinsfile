pipeline {
    agent any
    stages {
        stage('checkout repo') {
            steps {
                git branch: 'master'
                credentialsId: ''
                url: 'https://github.com/akulebyakin/graphql-training'
            }
        }
    }

    stage('build') {
        steps {
            sh './gradlew clean assemble'
        }
    }

    stage('run api tests') {
        steps {
            sh './gradlew test'
        }
    }

    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'build/allure-results']]
            ])
        }
    }
}