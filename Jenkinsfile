pipeline {
  agent {
    node {
      label 'Built-In Node'
    }

  }
  stages {
    stage('source') {
      steps {
        git(url: 'https://github.com/azxcv24/springboot_shoppingmall_api', branch: 'main', credentialsId: 'github-singnin')
      }
    }

    stage('Builed') {
      steps {
        tool 'gradle7'
      }
    }

    stage('Deploy') {
      steps {
        sh 'echo "Deploy springboot build"'
      }
    }

  }
}