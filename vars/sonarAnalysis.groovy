@NonCPS
def call(boolean abort = false, abortPipeline) {
	if (abortPipeline != true) {
		echo 'Ejecución de las pruebas de calidad de código'
		withSonarQubeEnv('sonarqube-token') {
			def scannerHome = tool name: 'SonarScanner'
			bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=practica2 -Dsonar.projectName=Practica2 -Dsonar.projectVersion=${BUILD_NUMBER}-practica2"
		}
		timeout(time: 5, unit: 'MINUTES') {
			waitForQualityGate abortPipeline: abort
		}
	} else return

}