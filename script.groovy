def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t vinothmohan/springboot:latest .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push vinothmohan/springboot:latest'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this