#!/usr/bin/env groovy

def call(){
    echo 'building the Docker image ...'

    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
        def user = env.DOCKER_USER
        def password = env.DOCKER_PASS
        //Initializing a global variable. Notice there is no def here
        sh "docker build -t mahdibouaziz/private:DevopsDS-2.0 ."
        echo "$password | docker login -u $user --password-stdin"
        sh "docker push mahdibouaziz/private:DevopsDS-2.0"
    }
}
