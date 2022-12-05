#!/usr/bin/env groovy

def call(String imageName){
    echo 'building the Docker image ...'

    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
        def user = env.DOCKER_USER
        def password = env.DOCKER_PASS
        //Initializing a global variable.
        sh "docker build -t $imageName ."
        echo "$password | docker login -u $user --password-stdin"
        sh "docker push $imageName"
    }
}
