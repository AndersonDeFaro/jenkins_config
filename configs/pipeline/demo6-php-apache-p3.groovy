pipeline {
    agent any 
    stages {
        stage ('Execute ansible - create database MySQL') {
            steps {
                ansiblePlaybook become: true, 
                                credentialsId: 'ssh_vagrant', 
                                disableHostKeyChecking: true, 
                                installation: 'ansible', 
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/install-mysql.yml'
            }
        }
    }
}