pipeline {
    agent any

    tools {
        maven 'Maven_3.8.x' // Make sure you have Maven installed in Jenkins
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/KobiRingelSwisa/DevOpsProject.git'
            }
        }

        stage('Run Gatling Load Test') {
            steps {
                sh 'mvn clean gatling:test'  // Runs Gatling load test
            }
        }
    }

    post {
        always {
            gatlingArchive()  // Archive the Gatling report
        }
    }
}
