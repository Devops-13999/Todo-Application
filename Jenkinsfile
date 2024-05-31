 pipeline{
     agent any
     tools{
        maven 'MAVEN'
        jdk 'JDK'
     }
     stages{
         stage("compile"){
             steps{
                script{
                   sh 'mvn clean compile'
               }
            }
        }
        stage("Build"){
             steps{
                script{
                   sh 'mvn clean install -DskipTests'
               }
            }
        }
     }
 }
 
