pipeline {
    agent any
    stages {
		stage ('GitClone - gitHub') {
			steps {
				git branch: 'main', 
					credentialsId: 'gitHub', 
					url: 'https://github.com/AndersonDeFaro/jenkins_config.git'
			}
		}
		stage ('Da a devida permissão de execução') {
			steps {
				echo 'Permissão - hosts.conf'
				sh 'chmod u+x ${WORKSPACE}/configs/ansible/hosts.conf'
				echo 'Permissão - demo1-pipeline.sh'
				sh 'chmod u+x ${WORKSPACE}/configs/shell/demo1-pipeline.sh'
			}
		}
		stage ('Execute teste ansible param') {
			steps {
				ansiblePlaybook become: true, 
								credentialsId: 'ssh_vagrant', 
								disableHostKeyChecking: true, 
								extras: '--extra-vars "path_script=${WORKSPACE}/configs/shell/demo1-pipeline.sh"',
								installation: 'ansible', 
								inventory: 'configs/ansible/hosts.conf', 
								playbook: 'configs/ansible/playbooks/exec-shell-script-param.yml'
			}
		}
    }
}