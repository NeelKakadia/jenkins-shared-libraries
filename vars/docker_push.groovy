def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
      sh '''
      echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
      '''
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}