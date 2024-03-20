@NonCPS
def call(String env_var = "none", boolean abort = false, abortPipeline) {
	if (abortPipeline != true) {
		if (env_var == 'master') {
			echo 'master'
			return
		} else if (String.contains(env_var, 'hotfix')) {
			echo 'contains hotfix'
			return
		} else {
			echo 'good branch'
			echo 'Ejecución de las pruebas de calidad de código'
			// withSonarQubeEnv('sonarqube-token') {
			// 	def scannerHome = tool name: 'SonarScanner'
			// 	bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=practica2 -Dsonar.projectName=Practica2 -Dsonar.projectVersion=${BUILD_NUMBER}-practica2"
			// }
			timeout(time: 5, unit: 'MINUTES') {
				// waitForQualityGate abortPipeline: abort
			}
		}
	} else return

}