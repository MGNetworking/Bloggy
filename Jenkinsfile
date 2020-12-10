node{

  stage('SCM Checkout'){
    git 'https://github.com/MGNetworking/Blog-J2E-ECF-3'
  }
  
  stage ('Compile-Package'){
  sh 'mvn package'
  }

}
