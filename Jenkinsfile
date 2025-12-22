pipeline{
	agent any
	options{
		buildDiscarder(logRotator(numToKeepStr: "5"))
	}
	stages{
		stage("Checkout"){
			steps{
				git url: "https://github.com/sandeepkrjsr/campaign-service.git", branch: "master"
			}
		}
		stage("Build"){
			steps{
				sh "mvn clean package -DskipTests"
			}
		}
		stage("Artifact"){
			steps{
				sh "cp target/*.jar target/campaign-service-${BUILD_NUMBER}.jar"
				archiveArtifacts artifacts: "target/campaign-service-${BUILD_NUMBER}.jar", fingerprint: true
			}
		}
	}
	post{
		always{
			cleanWs()
		}
		success{
			echo "Build successful"
		}
		failure{
			echo "Build failed. Please check the logs."
		}
	}
}