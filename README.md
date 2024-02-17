# jenkins_config

## Repositório para testes de uso do Jenkins com Ansible


### Dir: VMs 
    -> VirtualBox usadas com Vagrant

    Máquina Principal -> Fedora 38 com Jenkins e Ansible
    Debian 12 -> Máquina 2 com instalação inicial
    Ubuntu 2310 -> Máquina 3 com instalação Inicial


### Dir: Configs 
    -> Configurações que serão aplicadas a partir do Jenkins com Ansible

    Foi construido 2 scripts equivalentes, a diferença é que a pipeline está no Jenkins e o outro foi criado um arquivo Groovy para ser carregado via Pipeline SCM.

    Demo 1 -> Demo 3
    Demo 2 -> Demo 4