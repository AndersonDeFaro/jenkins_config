pipeline {
    agent any 
    stages {
        stage ('Execute script Demo 2') {
            steps {
                echo 'Execute shell - Demo 2 - Parametros'
                sh 'chmod u+x $WORKSPACE/configs/shell/demo2-pipeline.sh'
                script {
                    echo 'Adicionando tratamento de erro'
                    def status = sh(returnStatus:true, script: '$WORKSPACE/configs/shell/demo2-pipeline.sh ${ambiente} ${database}')
                    if (status == 0) {
                        echo 'Executado com sucesso!'
                    } else {
                        echo 'Executado com erro!'
                        sh 'exit 1'
                    }
                }
            }
        }
    }
}