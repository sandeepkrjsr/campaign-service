pipeline{
	agent any
	stages{
		stage('Checkout'){
			steps{
				git branch: 'master', url: 'https://github.com/sandeepkrjsr/campaign-service.git'
			}
		}
		stage('Build'){
			steps{
				sh 'mvn clean package -DskipTests'
			}
		}
	}
}