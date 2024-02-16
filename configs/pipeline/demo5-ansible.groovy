pipeline {
    agent any
    stages {
        stage ('Execute exemplo 1 - ansible') {
            steps {
                sh "ansible Debian -u vagrant --private-key=configs/ansible/ssh_private/id_rsa_fedora38.key -i configs/ansible/hosts.conf -m shell -a 'echo Hello, World'"
            }
        }
    }
}