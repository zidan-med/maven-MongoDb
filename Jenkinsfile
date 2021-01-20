pipeline{
    agent any
    stages{
        stage("git checkout"){
            steps{
                git credentialsId: "git_credentials", url: "https://github.com/zidan-med/maven-MongoDb.git"
                }
            
        }
        stage("build application"){
            steps{
                bat "mvn clean install"
            }
            
        }
        stage("Packaging de l'application "){
         steps{
             bat 'mvn package'
            }
        }
    }
    environment {
        EMAIL_TO = 'zidanmohammed59@gmail.com'
    }
    post {
        failure {
            emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                    to: "${EMAIL_TO}", 
                    subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
        }
        
    }
}
