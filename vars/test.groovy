#!/usr/bin/env groovy

def call(){
    echo "Testing application file"
    sh 'mvn test'
}

