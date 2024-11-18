
pipeline {
    agent any
    stages {
		stage ('Da a devida permissão de execução') {
			steps {
				echo 'Permissão - hosts.conf'
				sh 'chmod u+x ${WORKSPACE}/configs/ansible/hosts.conf'
				echo 'Permissão - demo1-pipeline.sh'
				sh 'chmod u+x ${WORKSPACE}/configs/shell/demo1-pipeline.sh'
			}
		}
		stage ('Execute teste ansible') {
			steps {
				ansiblePlaybook become: true, 
								credentialsId: 'ssh_vagrant', 
								disableHostKeyChecking: true, 
								installation: 'ansible', 
								inventory: 'configs/ansible/hosts.conf', 
								playbook: 'configs/ansible/playbooks/exec-shell-script.yml'
			}
		}
    }
}