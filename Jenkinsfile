pipeline {
    agent any

    // Environment variables
    environment {
        MAVEN_HOME = tool 'Maven 3.8.1'  // Replace with your actual configured Maven tool name in Jenkins
        JAVA_HOME = tool 'JDK 1.8'               // Replace with the correct Java version, if necessary
        PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Pull code from GitHub
                git branch: 'main', url: 'https://github.com/KobiRingelSwisa/DevOpsProject.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project with Maven
                sh '${MAVEN_HOME}/bin/mvn clean install'
            }
        }

        stage('Run Gatling Tests') {
            steps {
                // Run Gatling tests
                sh '${MAVEN_HOME}/bin/mvn gatling:test'
            }
        }
    }

    post {
        always {
            // Archive Gatling reports
            archiveArtifacts artifacts: 'target/gatling/**', allowEmptyArchive: true

            // Publish HTML Gatling reports
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/gatling',
                reportFiles: 'index.html',
                reportName: 'Gatling Test Report'
            ])
        }
    }
}
