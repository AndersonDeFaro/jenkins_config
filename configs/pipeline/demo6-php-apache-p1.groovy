pipeline {
    agent any 
    stages {
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