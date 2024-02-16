pipeline {
    agent any
    environment {
        ANSIBLE_PRIVATE_KEY=credentials('id-rsa-vagrant') 
    }
    stages {
        stage ('Execute exemplo 1 - ansible') {
            steps {
                sh 'ansible-playbook -i configs/ansible/hosts.conf --private-key=$ANSIBLE_PRIVATE_KEY configs/ansible/playbooks/apt-update-all.yml'
            }
        }
    }
}