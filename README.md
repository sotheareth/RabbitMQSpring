# RabbitMQSpring

###INSTALL ACTIVEMQ (VERSION: apache-activemq-5.9.0)
 - download file from http://activemq.apache.org/
 - start activemq
    - open command prompt as administrator
    - unzip download file to C:\Program Files
    - cd C:\Program Files\apache-activemq-5.9.0\bin\win64
    - run command: activemq.bat start
    - please check hawtio folder in webapps folder
    - http://localhost:8161/hawtio
- if you install rabbitmq there are some ports can be duplicate


###INSTALL RABBITMQ (VERSION: rabbitmq_server-3.6.6)
 - Download rabbitmq from rabbitmq.com
 - You must login as BUILT-IN ADMINISTRATOR user is root user in windows or sudo root in linux
 - Run installer from download file
 - cd C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.6\sbin
 - run command: rabbitmq-plugins.bat enable rabbitmq_management
 - restart RabbitMQ
 - http://localhost:15672/
 
###WHEN you want to delete queue from list you need IN RABBITMQ:
  - browse http://localhost:15672/cli/ to see guide information
  - click Download it from here to download python code 
  and save as "rabbitmqadmin.txt" and put in C:\Program Files\RabbitMQ Server
  - install python from https://www.python.org/downloads/
  - run command as administrator
  - cd C:\Program Files\RabbitMQ Server
  - python.exe rabbitmqadmin.txt list delete queues name=mydocumentsQueue 
