pipeline {
    agent any 
    stages {
        stage ('Carregar os parametros') {
            script {
                properties([parameters([choice(choices: ['desenvolvimento', 'teste', 'produção'], name: 'ambiente'), text('database')])])
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