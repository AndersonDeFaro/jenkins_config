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
		stage ('Atualizar arquivo apache2 Conf') {
			steps {
				echo 'Permissão - 000-default.conf'
				sh 'chmod 770 ${WORKSPACE}/configs/files/000-default.conf'
			}
		}
        stage ('Execute ansible - install WORDPRESS') {
            steps {
                ansiblePlaybook become: true, 
                                credentialsId: 'ssh_vagrant', 
                                disableHostKeyChecking: true, 
                                installation: 'ansible', 
                                extras: '--extra-vars "path_default=${WORKSPACE}/configs/files/000-default.conf"',
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/install-wordpress.yml'
            }
        }
    }
}