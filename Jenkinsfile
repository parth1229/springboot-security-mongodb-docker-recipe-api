pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        echo 'buiding the application'
        script {
          sh './gradlew clean test --no-daemon' //run a gradle task
        }
      }
    }
    stage("test") {
      steps {
        echo 'testing the application'
      }
    }
    stage("dockerize") {
      steps {
        echo 'dockerizing the application'
      }
    }
  }
}
