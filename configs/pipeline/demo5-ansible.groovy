pipeline {
    agent any
    environment {
        ANSIBLE_PRIVATE_KEY=credentials('id-rsa-vagrant') 
    }
    stages {
        stage('Execute 1 ansible') {
            steps {
                sh 'ansible-galaxy collection install -r ../ansible/requirements.yml'
                sh 'ansible-playbook -i ../ansible/hosts.conf --private-key=$ANSIBLE_PRIVATE_KEY ../ansible/playbooks/mariadb.yml'
            }
        }
    }
}