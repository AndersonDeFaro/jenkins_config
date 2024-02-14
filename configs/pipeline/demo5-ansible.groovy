pipeline {
    agent any
    stages {
        stage ('Execute exemplo 1 - ansible') {
            steps {
                ansiblePlaybook become: true, becomeUser: 'vagrant', credentialsId: 'ssh_vagrant', installation: 'ansible', inventory: 'configs/ansible/hosts.conf', playbook: 'configs/ansible/playbooks/apt-update-all.yml', sudoUser: null, vaultTmpPath: ''
            }
        }
    }
}