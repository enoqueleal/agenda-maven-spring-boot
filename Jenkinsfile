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
			steps { 
				sh 'mvn -X clean verify sonar:sonar ' +
				'-Dsonar.projectKey=SPRING-BOOT ' +
				'-Dsonar.host.url=http://localhost:9000 ' +
				'-Dsonar.login=82d81083adba6c62f5ed069356b1892492523a7d ' +
				'-Dsonar.language=java ' +
				'-Dsonar.exclusions=**/*Test*/** ' +
				'-Dsonar.coverage.jacoco.xmlReportPaths=target/jacoco-report/jacoco.xml'
			}
		}
	
	}
	
	post {
		always {
			deleteDir()
		}
	}
    
}