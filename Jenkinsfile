pipeline{
	agent any
	environment{
		DockerImage = "sandeepkrjsr/campaign-service"
		DockerTag = "v1.0.${BUILD_NUMBER}"
	}
	stages{
		stage("Checkout"){
			steps{
				git branch: "master", url: "https://github.com/sandeepkrjsr/campaign-service.git"
			}
		}
		stage("Build"){
			steps{
				sh "mvn clean package -DskipTests"
			}
		}
		stage("Build Image"){
			steps{
				sh "docker build -t ${DockerImage}:${DockerTag} ."
			}
		}
	}
}