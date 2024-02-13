pipeline {
    agent any 
    stages {
        stage ('Check gitHub') {
            steps {
                echo 'Checkout git repo'
                git branch: 'main', credentialsId: 'gitHub', url: 'https://github.com/AndersonDeFaro/jenkins_config.git'
            }
        }
        stage ('Execute script Demo 2') {
            steps {
                echo 'Execute shell - Demo 2 - Parametros'
                sh 'chmod u+x $WORKSPACE/configs/shell/demo2-pipeline.sh'
                sh '$WORKSPACE/configs/shell/demo2-pipeline.sh ${ambiente} ${database}'
            }
        }
    }
}