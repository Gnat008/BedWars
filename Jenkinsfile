pipeline {
   agent any
   tools {
      maven 'maven3.5.0'
      jdk 'jdk8'
   }
   stages {
      stage ('Initialization') {
          steps {
              echo 'Preparing for build'
          }
      }
      
      stage ('Build') {
          steps {
              sh 'mvn clean install' 
              archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
          }
          post {
              failure {
                  mail to: 'mep_eisen@web.de', subject: 'build of BedWars failed', body: 'build of BedWars failed'
              }
          }
      }
      
      stage ('Upload') {
        steps {
        	script {
        		env.BUILDTYPE = readPomVersion().endsWith("-SNAPSHOT") ? "snapshots" : "releases";
        	}
            sh "/srv/hudson/upload_game.sh ${env.BUILDTYPE} BedWars-Plugin/target 1 BedWars MGBedWars-Plugin"
      	}
      }
      
      stage ('Deploy') {
          when {
              expression {
                  currentBuild.result == null || currentBuild.result == 'SUCCESS'
              }
          }
          steps {
              sh 'mvn -Deisenschmiede.deployment=true -Dmaven.test.skip=true -DskipTests deploy'
          }
          post {
              failure {
                  mail to: 'mep_eisen@web.de', subject: 'deploy of BedWars failed', body: 'deploy of BedWars failed'
              }
          }
      }
   }
}