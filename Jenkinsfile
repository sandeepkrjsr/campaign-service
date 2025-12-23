pipeline{
	agent any
	options{
		buildDiscarder(logRotator(numToKeepStr: "5"))
	}
	environment{
		Name = "campaign-service"
		Tag = "v1.0.${BUILD_NUMBER}"
		Image = "sandeepkrjsr/campaign-service"
	}
	stages{
		stage("Checkout"){
			steps{
				git url: "https://github.com/sandeepkrjsr/campaign-service.git", branch: "master"
			}
		}
		stage("Build JAR"){
			steps{
				sh "mvn clean package -DskipTests"
			}
		}
		stage("Build Artifact"){
			steps{
				sh "cp target/*.jar target/${Name}-${Tag}.jar"
				archiveArtifacts artifacts: "target/${Name}-${Tag}.jar", fingerprint: true
			}
		}
		stage('Build Docker Image'){
			steps{
				sh "sudo docker build -t ${Name}:${Tag} ."
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