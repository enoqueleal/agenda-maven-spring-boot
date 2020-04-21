pipeline {

    agent any
    
     tools {
        maven "maven"
    }
    
    stages {
    
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        
        stage('Statistical analysis') { 
	        withSonarQubeEnv('sonar-scanner') { 
		          sh 'mvn sonar:sonar ' + 
		          '-Dsonar.projectKey=SPRING-BOOT ' +
		          '-Dsonar.host.url=http://localhost:9000 '
		          '-Dsonar.login=82d81083adba6c62f5ed069356b1892492523a7d ' +
		          '-Dsonar.language=java ' +
		          '-Dsonar.test.inclusions=**/*Test*/** ' +
		          '-Dsonar.exclusions=**/*Test*/**'
	        }
        }
        
    }
    
    post {
        always {
            deleteDir()
        }
    }
    
}