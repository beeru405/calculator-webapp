pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/yourusername/calculator-webapp.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                // Implement deployment steps here
                deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://192.168.138.114:8081/')], contextPath: null, war: '**/*.war'
            }
        }
    }
}
