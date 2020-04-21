pipeline {

    agent any
    
     tools {
        maven "Maven"
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
	        withSonarQubeEnv('Sonar') { 
		          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.3.0.603:sonar' + 
		          '-f all/pom.xml' +
		          '-Dsonar.projectKey=SPRING-BOOT' +
		          '-Dsonar.host.url=http://localhost:9000'
		          '-Dsonar.login=82d81083adba6c62f5ed069356b1892492523a7d' +
		          '-Dsonar.language=java' +
		          '-Dsonar.test.inclusions=**/*Test*/**' +
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