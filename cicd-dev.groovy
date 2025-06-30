node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/tcltlsport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/tcltlsport.git'), string(name: 'PORT_DESCRIPTION', value: 'This package provides an extension which implements SSL and TLS encryption over TCP network communication channels utilizing the OpenSSL library' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
