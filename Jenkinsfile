pipeline{
	agent any
	triggers {
        pollSCM('H/5 * * * *')
    }
	options{
		buildDiscarder(logRotator(numToKeepStr: "5"))
	}
	environment{
		Name = "campaign-service"
		Tag = "v1.0.${BUILD_NUMBER}"
		Image = "sandeepkrjsr/campaign-service"
	}
	parameters{
		booleanParam(
			name: 'BUILD_DOCKER_IMAGE', 
			defaultValue: true, 
			description: 'Build the project'
		)
		booleanParam(
			name: 'PUSH_DOCKER_IMAGE', 
			defaultValue: true, 
			description: 'Build the project'
		)
		booleanParam(
			name: 'DEPLOY_CONTAINER', 
			defaultValue: true, 
			description: 'Deploy container after build'
		)
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
				if(params.BUILD_DOCKER_IMAGE){
					sh "docker build -t ${Name}:${Tag} ."
				}
			}
		}
		stage('Push Image'){
			steps{
				if(params.PUSH_DOCKER_IMAGE){
					sh "docker push ${Name}:${Tag}"
				}
			}
		}
		stage('Container Deployment'){
			steps{
				if(params.DEPLOY_CONTAINER){
					sh "docker-compose up -d --pull always"
				}
			}
		}
	}
	post{
		always{
			cleanWs()
		}
		success{
			echo "Build and Deployed Successfully: $Name:$Tag"
		}
		failure{
			echo "Build failed. Please check the logs."
		}
	}
}