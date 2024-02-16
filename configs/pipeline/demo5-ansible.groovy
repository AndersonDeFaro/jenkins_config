pipeline {
    agent any 
    stages {
        stage ('Execute execute teste ansible') {
            steps {
                ansiblePlaybook become: true, 
                                credentialsId: 'ssh_vagrant', 
                                disableHostKeyChecking: true, 
                                installation: 'ansible', 
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/apt-update-all.yml'
            }
        }
    }
}