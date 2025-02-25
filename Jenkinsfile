pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        DOCKER_IMAGE_NAME = 'rksingh5/scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/Rishabh208/SPE_Mini_Project.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    sh 'mvn clean package' // Build the Java project
                    sh 'mvn test' // Run unit tests
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def imageExists = sh(script: "docker images -q ${DOCKER_IMAGE_NAME}", returnStdout: true).trim()
                    if (imageExists) {
                        echo "Docker image already exists. Skipping build."
                    } else {
                        echo "Building new Docker image..."
                        docker.build("${DOCKER_IMAGE_NAME}", '.')
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-credentials') {
                        sh 'docker tag calculator rksingh5/scientific-calculator:latest'
                        sh 'docker push rksingh5/scientific-calculator'
                    }
                }
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                script {
                    withEnv(["ANSIBLE_HOST_KEY_CHECKING=False"]) {
                        ansiblePlaybook(
                            playbook: 'deploy.yml',
                            inventory: 'hosts.ini'
                        )
                    }
                }
            }
        }
    }

    post {
        success {
            mail to: 'rkumarsingh136@gmail.com',
                 subject: "Application Deployment SUCCESS: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build was successful!"
        }
        failure {
            mail to: 'rkumarsingh136@gmail.com',
                 subject: "Application Deployment FAILURE: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build failed."
        }
        always {
            cleanWs()
        }
    }
}
