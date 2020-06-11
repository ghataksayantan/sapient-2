pipeline {
  agent any

  tools {
    maven 'mvn-3.6.2'
  }

  stages {
    stage('build maven') {
      steps {
        sh 'mvn install'
      }
    }
    
    stage('create docker') {
      steps {
      sh "docker build -t sapient-test:1.0."
      }
    }   
    
  }

  
}