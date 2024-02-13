pipeline {
    agent any 
    stages {
        stage ('Execute script Demo 1') {
            steps {
                echo 'Execute shell - Demo 1 - ECHO SIMPLES'
                sh 'chmod u+x $WORKSPACE/configs/shell/demo1-pipeline.sh'
                sh '$WORKSPACE/configs/shell/demo1-pipeline.sh'
            }
        }
    }
}