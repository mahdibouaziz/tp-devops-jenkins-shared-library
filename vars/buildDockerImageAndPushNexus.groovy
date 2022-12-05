#!/usr/bin/env groovy

def call(String imageName){
    echo 'building the Docker image To Nexus ...'

    withCredentials([usernamePassword(credentialsId: 'nexus-repo', passwordVariable: 'NEXUS_PASS', usernameVariable: 'NEXUS_USER')]) {
        def user = env.NEXUS_USER
        def password = env.NEXUS_PASS
        //Initializing a global variable. Notice there is no def here
        sh "docker build -t $imageName ."
        echo "$password | docker login -u $user --password-stdin 192.168.100.162:8083"
        sh "docker push $imageName"
    }
}

