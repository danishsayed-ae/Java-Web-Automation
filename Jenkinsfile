pipeline {
    agent any

    environment {
        DOCKER_COMPOSE_FILE = 'Docker/Docker-Compose-Grid.yml'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository
                git url: 'https://github.com/danishsayed-ae/Java-Web-Automation.git', branch: 'main'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                script {
                    echo 'Starting Selenium Grid using Docker Compose...'
                    sh 'docker-compose -f ${DOCKER_COMPOSE_FILE} up -d'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    echo 'Running test suite...'
                    // Command to run your tests
                    // Adjust the below command to suit your project
                    sh 'mvn clean test -Dplatform=remote'
                }
            }
        }
    }

    post {
        always {
            stage('Stop Selenium Grid') {
                steps {
                    script {
                        echo 'Stopping Selenium Grid...'
                        sh 'docker-compose -f ${DOCKER_COMPOSE_FILE} down'
                    }
                }
            }
        }
    }
}
