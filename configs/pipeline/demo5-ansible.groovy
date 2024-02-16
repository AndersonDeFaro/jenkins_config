pipeline {
    agent any
    stages {
        state ('Ping server - Debian 12') {
            steps {
                sh 'ping 192.168.56.10'
                sh 'ping debian12'
            }
        }
        stage ('Execute exemplo 1 - ansible') {
            steps {
                ansiblePlaybook become: true, 
                                becomeUser: 'vagrant', 
                                credentialsId: 'ssh_vagrant', 
                                installation: 'ansible', 
                                inventory: 'configs/ansible/hosts.conf', 
                                playbook: 'configs/ansible/playbooks/apt-update-all.yml', 
                                sudoUser: null, 
                                vaultTmpPath: ''
            }
        }
    }
}