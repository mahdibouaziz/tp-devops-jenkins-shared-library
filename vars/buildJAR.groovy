#!/usr/bin/env groovy

def call(){
    echo 'building the JAR ...'
    sh 'mvn package'
}
