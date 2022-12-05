#!/usr/bin/env groovy
package com.sharedfunctions

class Docker implements Serializable {
    def script

    Docker(script){
        this.script=script
    }

    def buildDockerImage(String imageName){
        script.echo 'building the Docker image ...'
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
            def user = script.env.DOCKER_USER
            def password = script.env.DOCKER_PASS
            //Initializing a global variable.
            script.sh "docker build -t $imageName ."
            script.echo "$password | docker login -u $user --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}

