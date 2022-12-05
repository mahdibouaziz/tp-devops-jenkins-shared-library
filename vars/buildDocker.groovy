#!/usr/bin/env groovy

def call(String imageName){
    echo 'building the Docker image ...'
    sh "docker build -t $imageName ."
}
