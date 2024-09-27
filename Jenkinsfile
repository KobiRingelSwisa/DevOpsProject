pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Your-Configured-Maven-Name' // Update with the correct Maven tool name
        JAVA_HOME = tool 'JDK 1.8'
        PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
    }
    
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo/gatling-loadtest.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Run Gatling Tests') {
            steps {
                sh 'mvn gatling:test'
            }
        }
    }
    
    post {
        always {
            // Archive Gatling reports (no need for a node block here)
            archiveArtifacts artifacts: 'target/gatling/**', allowEmptyArchive: true
            
            // Optionally, publish HTML reports
            publishHTML([allowMissing: false,
                         alwaysLinkToLastBuild: true,
                         keepAll: true,
                         reportDir: 'target/gatling',
                         reportFiles: 'index.html',
                         reportName: 'Gatling Test Report'])
        }
    }
}
