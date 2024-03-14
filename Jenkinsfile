pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git branch: 'main', url: 'https://github.com/beeru405/webcalc-java.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Use Maven to build and test the project
                sh 'mvn clean test install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                // Copy the war file to Tomcat webapps directory
                deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://192.168.138.114:8081/')], contextPath: null, war: '**/*.war'
            }
        }

        stage('API Testing') {
            steps {
                script {
                    // Wait for Tomcat to deploy the application
                    sleep(time: 30, unit: 'SECONDS')

                    // Perform API testing for GET and POST methods
                    def getResponse = sh(script: 'curl -X GET http://192.168.138.114:8081/webapp-0.2/', returnStdout: true).trim()
                    def postResponse = sh(script: 'curl -X POST -d "n1=5&n2=6&r1=add" http://192.168.138.114:8081/webapp-0.2/firstHomePage', returnStdout: true).trim()

                    // Print the responses
                    echo "GET Response: ${getResponse}"
                    echo "POST Response: ${postResponse}"

                    // Add additional checks/assertions based on the expected responses
                    // Example: assert getResponse.contains("ExpectedText")
                    // Example: assert postResponse.contains("ExpectedText")
                }
            }
        }
    }

    post {
        success {
            // Notify success, send emails, or perform other post-build actions
            echo 'Deployment successful!'
        }
        failure {
            // Notify failure, send emails, or perform other post-build actions
            echo 'Deployment failed!'
        }
    }
}
