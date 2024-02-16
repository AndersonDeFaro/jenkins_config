pipeline {
    agent any 
    stages {
        stage ('Check gitHub') {
            steps {
                echo 'Checkout git repo'
                git branch: 'main', credentialsId: 'gitHub', url: 'https://github.com/AndersonDeFaro/jenkins_config.git'
            }
        }
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