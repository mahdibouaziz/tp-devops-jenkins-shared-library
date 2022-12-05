#!/usr/bin/env groovy

import com.sharedfunctions.Docker
def call(String imageName){
    return new Docker(this).buildDockerImage(imageName)
}
