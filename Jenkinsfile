pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "rksingh5/scientific-calculator"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Rishabh208/scientific-calculator.git'
            }
        }

        stage('Build') {
            steps {
                sh '/usr/bin/mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh 'docker run -d -p 8080:8080 $DOCKER_IMAGE'
            }
        }

        stage('Deploy with Ansible') {
                    steps {
                        sh 'ansible-playbook -i hosts.ini deploy.yml'
                    }
                }
    }

    post {
        success {
            echo 'Pipeline execution successful!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
