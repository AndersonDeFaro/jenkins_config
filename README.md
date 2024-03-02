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

    # Desafios
    No curso que estou fazendo na Alura o material está bem defasado, por esse motivo estou passando algumas dificuldade e tendo que ajustar os código de acorodo com o que tenho
    sentido necessidade.
    Ex 1 .: Uso do comando 'community.mysql.mysql_db' e criação de um usuário DBA pela dificuldade de acesso ao usuário ROOT do MySQL.

### Configurações relavantes para o Jenkins

#### Usar o plugin: Locale
  -> Setar a linguage English (EN) como Default pra acabar com a bagunça de linguagem que fica no browser

#### Usar o plugin: Slack Notification
  -> Usar o plugin slack para gerar notificações e identificar a situação dos jobs / pipelines