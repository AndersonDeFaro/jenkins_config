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
        stage ('Execute teste ansible - php8 apache2') {
            steps {
                ansiblePlaybook become: true, 
                                credentialsId: 'ssh_vagrant', 
                                disableHostKeyChecking: true, 
                                installation: 'ansible', 
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/php5-apache.yml'
            }
        }
    }
}