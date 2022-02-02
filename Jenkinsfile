pipeline{
    agent any
    stages{
        stage('Git clone'){
            steps{
                git 'https://github.com/iamvinot/maven-project.git'
            }
        }
        
        stage('maven build'){
            steps{
                sh 'mvn package'
            }
        }
        stage('Create Dockerimage'){
            steps{
                sh 'docker build -t vinothmohan/springboot:latest .'
            }
        }
        
    }
}
