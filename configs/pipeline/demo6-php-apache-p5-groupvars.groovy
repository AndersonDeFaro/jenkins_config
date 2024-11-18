pipeline {
    agent any 
    stages {
		stage ('Atribuir as permissões necessárias') {
			steps {
			    script {
    			    echo 'Permissão - repositório'
    				sh 'chmod 770 ${WORKSPACE}/configs/*'
			    }
			}
		}
		stage ('Copiar o arquivo com variaveis para o ansible - GROUPVARS') {
		    steps {
		        script {
    		        echo 'Zerando os arquivos do diretorio - group_vars'
        		    def statusRM = sh(returnStatus:true, script: 'rm -r /etc/ansible/group_vars/*.yml')
                    if (statusRM == 0) {
                        echo 'Limpeza do diretorio - Executado com sucesso!'
                    }
        		    echo 'Copiando arquivo para group_vars'
        		    def statusCP = sh(returnStatus:true, script: 'cp ${WORKSPACE}/configs/group_vars/all.yml /etc/ansible/group_vars/'  )
        		    if (statusCP == 0) {
                        echo 'Copia realizada com sucesso!'
                    } else {
                        echo 'Erro na execução da copia!'
                        sh 'exit 1'
                    }    
		        }
		    }
		}
		stage ('Execute ansible - create database MySQL - GROUPVARS') {
            steps {
                ansiblePlaybook become: true, 
                                credentialsId: 'ssh_vagrant', 
                                disableHostKeyChecking: true, 
                                installation: 'ansible', 
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/install-mysql-groupvars.yml'
            }
        }
        stage ('Execute ansible - install WORDPRESS - GROUPVARS') {
            steps {
                ansiblePlaybook become: true, 
                                credentialsId: 'ssh_vagrant', 
                                disableHostKeyChecking: true, 
                                installation: 'ansible', 
                                extras: '--extra-vars "path_default=${WORKSPACE}"',
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/install-wordpress-groupvars.yml'
            }
        }
    }
}