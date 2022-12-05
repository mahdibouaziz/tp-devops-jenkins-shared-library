#!/usr/bin/env groovy

def call(){
    sh 'docker-compose up -d'
    sh 'docker ps'
}

